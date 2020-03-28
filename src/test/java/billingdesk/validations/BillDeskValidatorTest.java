package billingdesk.validations;

import billingdesk.exceptions.InvalidCustomerTypeException;
import discount.exceptions.InvalidInputException;
import java.math.BigDecimal;
import org.junit.Test;

public class BillDeskValidatorTest {

    BillDeskValidator billDeskValidator = new BillDeskValidator();

    @Test(expected = InvalidInputException.class)
    public void testValidateInputs_PurchaseAmountZero_Fails() {
        billDeskValidator.validateInputs("Regular", new BigDecimal(0));
    }

    @Test(expected = InvalidInputException.class)
    public void testValidateInputs_NegativePurchaseAmount_Fails() {
        billDeskValidator.validateInputs("Premium", new BigDecimal(-5000));
    }

    @Test(expected = InvalidInputException.class)
    public void testValidateInputs_NullCustomerType_Fails() {
        billDeskValidator.validateInputs(null, new BigDecimal(20000));
    }

    @Test(expected = InvalidCustomerTypeException.class)
    public void testValidateInputse_InvalidCustomerType_Fails() {
        billDeskValidator.validateInputs("InvalidCustomerType", new BigDecimal(20000));
    }

    @Test
    public void testValidateInputs_ValidInput_Pass() {
        billDeskValidator.validateInputs("Regular", new BigDecimal(20000));
    }
}