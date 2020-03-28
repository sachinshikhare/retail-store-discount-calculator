package billingdesk.validations;

import billingdesk.exceptions.InvalidCustomerTypeException;
import customer.CustomerService;
import discount.exceptions.InvalidInputException;
import java.math.BigDecimal;

public class BillDeskValidator {

    CustomerService customerService = new CustomerService();

    public void validateInputs(final String customerType, final BigDecimal purchaseAmount) {

        if (purchaseAmount == null) {
            throw new InvalidInputException("purchaseAmount should not be null");
        }
        if (purchaseAmount.compareTo(new BigDecimal(0)) <= 0) {
            throw new InvalidInputException("purchaseAmount should be non zero positive value");
        }

        if (customerType == null) {
            throw new InvalidInputException("customerType should not be null");
        }
        if (!customerService.isCustomerTypeValid(customerType)) {
            throw new InvalidCustomerTypeException(String.format("customerType %s is invalid", customerType));
        }
    }
}
