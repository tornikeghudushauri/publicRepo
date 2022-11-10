package ge.ufc.webservices.dao;


import ge.ufc.webservices.exception.AgentAccessDenied;
import ge.ufc.webservices.exception.AgentAuthFailed;
import ge.ufc.webservices.exception.TransactionNotFound;
import ge.ufc.webservices.exception.UserNotFound;
import ge.ufc.webservices.model.Transaction;
import ge.ufc.webservices.model.User;

import java.sql.*;

public class ServiceADaoImpl implements ServiceADao {

    private static final String DUPLICATE_KEY_ERROR = "23505";

    private Connection connection;

    public ServiceADaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User check(int userId) throws UserNotFound, DatabaseException {
        String getUser = "SELECT * FROM users WHERE user_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(getUser)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("user_id"), rs.getString("first_name"),
                            rs.getString("last_name"), rs.getString("id_number"),
                            rs.getDouble("balance"));
                } else {
                    throw new UserNotFound();
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Can't get user", e);
        }
    }

    @Override
    public int pay(String transactionId, int userId, double amount) throws UserNotFound, DatabaseException, TransactionNotFound {
        int systemTransactionId = 0;
        try {
            User user = check(userId);
            if (user != null) {
                String sql = "UPDATE users SET balance = ? WHERE user_id = ?";
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setDouble(1, user.getBalance() + amount);
                    ps.setInt(2, userId);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                String sql2 = "INSERT INTO transactions (agent_transaction_id, user_id, amount) VALUES (?, ?, ?)";
                try (PreparedStatement ps = connection.prepareStatement(sql2)) {
                    ps.setString(1, transactionId);
                    ps.setInt(2, userId);
                    ps.setDouble(3, amount);
                    boolean isAdded = ps.execute();
//                    if (isAdded) {
                    String getTransaction = "SELECT system_transaction_id FROM transactions WHERE agent_transaction_id = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(getTransaction)) {
                        preparedStatement.setString(1, transactionId);
                        try (ResultSet rs = preparedStatement.executeQuery()) {
                            if (rs.next()) {
                                systemTransactionId = rs.getInt("system_transaction_id");
                            } else {
                                throw new TransactionNotFound();
                            }
                        }
                    } catch (SQLException e) {
                        throw new DatabaseException("Can't get user", e);
                    }
//                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (DatabaseException e) {
            throw new DatabaseException("UserId does not exist");
        }
        return systemTransactionId;
    }

    @Override
    public boolean checkAgent(String agentId, String password) {
        String sql = "SELECT * FROM Agents WHERE agent_id = ? AND password = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, agentId);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                throw new AgentAuthFailed();
            }
        } catch (SQLException | AgentAuthFailed e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean checkAgentIp(String agentId, String agentIp) {
        String sql = "SELECT * FROM agent_access WHERE agent_id = ? AND allowed_ip = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, agentId);
            statement.setString(2, agentIp);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    throw new AgentAccessDenied();
                }
            } catch (AgentAccessDenied e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Transaction status(String agentTransactionId) throws DatabaseException, TransactionNotFound {
        String sql = "SELECT * FROM transactions WHERE agent_transaction_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, agentTransactionId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Transaction(rs.getInt("system_transaction_id"),rs.getInt("user_id"), rs.getString("agent_transaction_id"),
                            rs.getInt("agent_id"),rs.getDouble("amount"),rs.getTimestamp("transaction_date"));
                } else {
                    throw new TransactionNotFound();
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Database exception", e);
        }
    }
}