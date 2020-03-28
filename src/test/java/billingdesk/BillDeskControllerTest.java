package billingdesk;

import static org.junit.Assert.*;
import billingdesk.exceptions.InvalidCustomerTypeException;
import discount.exceptions.InvalidInputException;
import java.math.BigDecimal;
import org.junit.Test;

public class BillDeskControllerTest {

    BillDeskController controller = new BillDeskController();

    @Test
    public void testCalculateTotalBillAsPerCustomerType_ValidPurchaseAmount_Pass() {
        BigDecimal result = controller.calculateTotalBillAsPerCustomerType("Premium", new BigDecimal(25000));
        assertNotNull(result);
        assertEquals(BigDecimal.valueOf(19300), result);
    }

}