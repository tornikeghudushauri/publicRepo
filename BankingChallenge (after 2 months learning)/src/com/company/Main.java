package com.company;

public class Main {

    public static void main(String[] args) {
    Bank bank = new Bank("BankOfGeorgia");
    bank.addBranch("Solo");
    bank.addCustomer("Solo","Ghudu",1250.85);
        bank.addCustomer("Solo","Ghudu1",1250.851);
        bank.addCustomer("Solo","Ghudu2",1250.852);
        bank.addCustomer("Solo","Ghudu3",1250.853);
    bank.addCustomer("Solo","Ebita",3569.34);
    bank.addCustomerTransaction("Solo","Ebita",140.90);
    bank.listCustomers("Solo",true);
    }

}
