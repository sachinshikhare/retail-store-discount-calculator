package util;

import static org.junit.Assert.*;
import discount.CustomerType;
import discount.exceptions.InvalidInputException;
import org.junit.Test;

public class StringToEnumConverterTest {

    @Test
    public void testCovert_Valid_Pass() {
        CustomerType customerType = StringToEnumConverter.convert("Regular");
        assertNotNull(customerType);
        assertEquals(CustomerType.REGULAR, customerType);
    }

    @Test(expected = InvalidInputException.class)
    public void testCovert_Invalid_Fail() {
        StringToEnumConverter.convert("Invalid");
    }

}