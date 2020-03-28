package billingdesk.exceptions;

public class InvalidCustomerTypeException extends RuntimeException {
    public InvalidCustomerTypeException(final String message) {
        super(message);
    }
}
