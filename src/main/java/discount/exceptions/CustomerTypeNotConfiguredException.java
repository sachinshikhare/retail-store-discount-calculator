package discount.exceptions;

import java.util.function.Supplier;

public class CustomerTypeNotConfiguredException extends RuntimeException {
    public CustomerTypeNotConfiguredException(String msg) {
        super(msg);
    }

}
