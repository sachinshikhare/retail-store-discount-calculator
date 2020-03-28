package billingdesk;

import discount.CustomerType;
import discount.DiscountCalculatorService;
import discount.validations.DiscountValidator;
import java.math.BigDecimal;
import util.StringToEnumConverter;

public class BillDeskController {

    DiscountCalculatorService discountCalculatorService = new DiscountCalculatorService();

    public BigDecimal calculateTotalBillAsPerCustomerType(final String customerTypeString, final BigDecimal purchaseAmount) {

        CustomerType customerType = StringToEnumConverter.convert(customerTypeString);
        DiscountValidator.validatePurchaseAmount(purchaseAmount);
        return discountCalculatorService.calculateBillAmount(customerType, purchaseAmount);
    }
}
