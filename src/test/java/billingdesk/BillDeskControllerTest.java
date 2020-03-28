package billingdesk;

import static org.junit.Assert.*;
import discount.exceptions.InvalidInputException;
import java.math.BigDecimal;
import org.junit.Test;

public class BillDeskControllerTest {

    @Test(expected = InvalidInputException.class)
    public void testCalculateTotalBillAsPerCustomerType_PurchaseAmountZero_Fails() {
        new BillDeskController().calculateTotalBillAsPerCustomerType("Regular", new BigDecimal(0));
    }

    @Test(expected = InvalidInputException.class)
    public void testCalculateTotalBillAsPerCustomerType_NegativePurchaseAmount_Fails() {
        new BillDeskController().calculateTotalBillAsPerCustomerType("Premium", new BigDecimal(-5000));
    }

    @Test
    public void testCalculateTotalBillAsPerCustomerType_ValidPurchaseAmount_Pass() {
        BigDecimal result = new BillDeskController().calculateTotalBillAsPerCustomerType("Premium", new BigDecimal(25000));
        assertNotNull(result);
        assertEquals(BigDecimal.valueOf(19300), result);
    }

}