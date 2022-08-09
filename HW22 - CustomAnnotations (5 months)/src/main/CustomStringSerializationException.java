package main;

public class CustomStringSerializationException extends Throwable {
    public CustomStringSerializationException(String s) {
        System.err.println(s);
    }
}
