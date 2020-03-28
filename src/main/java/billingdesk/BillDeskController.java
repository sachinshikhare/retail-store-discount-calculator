package billingdesk;

import billingdesk.validations.BillDeskValidator;
import discount.DiscountCalculatorService;
import java.math.BigDecimal;

public class BillDeskController {

    DiscountCalculatorService discountCalculatorService = new DiscountCalculatorService();
    BillDeskValidator billDeskValidator = new BillDeskValidator();

    public BigDecimal calculateTotalBillAsPerCustomerType(final String customerType, final BigDecimal purchaseAmount) {

        billDeskValidator.validateInputs(customerType, purchaseAmount);
        return discountCalculatorService.calculateBillAmount(customerType, purchaseAmount);
    }
}
