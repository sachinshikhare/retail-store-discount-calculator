package discount.validations;

import discount.exceptions.InvalidInputException;
import java.math.BigDecimal;

public class DiscountValidator {

    public static void validatePurchaseAmount(final BigDecimal purchaseAmount) {
        if (purchaseAmount == null) {
            throw new InvalidInputException(String.format("purchaseAmount should not be null"));
        }
        if (purchaseAmount.compareTo(new BigDecimal(0)) <= 0) {
            throw new InvalidInputException(String.format("purchaseAmount should be non zero positive value"));
        }
    }
}
