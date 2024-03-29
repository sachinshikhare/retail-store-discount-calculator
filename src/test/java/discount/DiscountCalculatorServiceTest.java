package discount;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Test;

public class DiscountCalculatorServiceTest {

    DiscountCalculatorService discountCalculatorService = new DiscountCalculatorService();

    @Test
    public void testCalculateBillAmount_Valid_ShouldPass_1() {
       BigDecimal output = discountCalculatorService.calculateBillAmount("Regular", new BigDecimal(5000));
       assertNotNull(output);
       assertEquals(new BigDecimal(5000), output);
    }

    @Test
    public void testCalculateBillAmount_Valid_ShouldPass_2() {
        BigDecimal output = discountCalculatorService.calculateBillAmount("Regular", new BigDecimal(10000));
        assertNotNull(output);
        assertEquals(new BigDecimal(9500), output);
    }

    @Test
    public void testCalculateBillAmount_Valid_ShouldPass_3() {
        BigDecimal output = discountCalculatorService.calculateBillAmount("Regular", new BigDecimal(15000));
        assertNotNull(output);
        assertEquals(new BigDecimal(13500), output);
    }

    @Test
    public void testCalculateBillAmount_Valid_ShouldPass_4() {
        BigDecimal output = discountCalculatorService.calculateBillAmount("Premium", new BigDecimal(4000));
        assertNotNull(output);
        assertEquals(new BigDecimal(3600), output);
    }

    @Test
    public void testCalculateBillAmount_Valid_ShouldPass_5() {
        BigDecimal output = discountCalculatorService.calculateBillAmount("Premium", new BigDecimal(8000));
        assertNotNull(output);
        assertEquals(new BigDecimal(7000), output);
    }

    @Test
    public void testCalculateBillAmount_Valid_ShouldPass_6() {
        BigDecimal output = discountCalculatorService.calculateBillAmount("Premium", new BigDecimal(12000));
        assertNotNull(output);
        assertEquals(new BigDecimal(10200), output);
    }

    @Test
    public void testCalculateBillAmount_Valid_ShouldPass_7() {
        BigDecimal output = discountCalculatorService.calculateBillAmount("Premium", new BigDecimal(20000));
        assertNotNull(output);
        assertEquals(new BigDecimal(15800), output);
    }

    @Test
    public void testCalculateBillAmount_Valid_ShouldPass_8() {
        BigDecimal output = discountCalculatorService.calculateBillAmount("Regular", new BigDecimal(24350300));
        assertNotNull(output);
        assertEquals(new BigDecimal(19481740), output);
    }

    @Test
    public void testCalculateBillAmount_Valid_ShouldPass_9() {
        BigDecimal output = discountCalculatorService.calculateBillAmount("Premium", new BigDecimal(2000000));
        assertNotNull(output);
        assertEquals(new BigDecimal(1401800), output);
    }

    @Test
    public void testCalculateBillAmount_Valid_ShouldPass_10() {
        BigDecimal output = discountCalculatorService.calculateBillAmount("Premium", new BigDecimal(723462200));
        assertNotNull(output);
        assertEquals(new BigDecimal(506425340), output);
    }
}