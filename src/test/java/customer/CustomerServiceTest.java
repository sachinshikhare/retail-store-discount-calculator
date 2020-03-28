package customer;

import static org.junit.Assert.*;
import org.junit.Test;

public class CustomerServiceTest {

    CustomerService customerService = new CustomerService();

    @Test
    public void testIsCustomerTypeValid_ValidInput_Pass() {
        assertTrue(customerService.isCustomerTypeValid("Premium"));
        assertFalse(customerService.isCustomerTypeValid("InvalidCustomerType"));
        assertFalse(customerService.isCustomerTypeValid(null));
    }

}