package exceptions;

public class CustomerServiceException extends Exception {
    public CustomerServiceException() {
        super("Customer error!");
    }
}
