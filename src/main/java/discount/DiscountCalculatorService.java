package discount;

import discount.configreader.DiscountConfigReader;
import java.math.BigDecimal;

public class DiscountCalculatorService {

    public static final String PRICE_RANGE_KEY_ONWARDS = "onwards";
    public static final String PRICE_RANGES_SEPARATOR = ";";
    public static final String PRICE_DISCOUNT_SEPARATOR = ":";

    public BigDecimal calculateBillAmount(final String customerType, final BigDecimal purchaseAmount) {

        return purchaseAmount.subtract(this.calculateDiscountAmount(customerType, purchaseAmount));
    }

    private BigDecimal calculateDiscountAmount(final String customerType, final BigDecimal purchaseAmount) {
        BigDecimal purchaseAmountToProcess = purchaseAmount;
        String discountConfig = DiscountConfigReader.getDiscountConfigByCustomerType(customerType);

        String[] pricesAndRespectiveDiscounts = discountConfig.split(PRICE_RANGES_SEPARATOR);
        BigDecimal discountedAmount = new BigDecimal(0);
        for (String priceAndRespectiveDiscount: pricesAndRespectiveDiscounts) {
            String[] tokens = priceAndRespectiveDiscount.split(PRICE_DISCOUNT_SEPARATOR);
            BigDecimal discountRangeAmount = tokens[0].equals(PRICE_RANGE_KEY_ONWARDS) ? purchaseAmountToProcess : new BigDecimal(tokens[0]);
            int percentDiscount = Integer.parseInt(tokens[1]);

            if (purchaseAmountToProcess.compareTo(discountRangeAmount) == -1) {
                discountedAmount = discountedAmount.add(
                    purchaseAmountToProcess.divide(BigDecimal.valueOf(100)).multiply(BigDecimal.valueOf(percentDiscount))
                );
                break;
            } else {
                purchaseAmountToProcess = purchaseAmountToProcess.subtract(discountRangeAmount);
                discountedAmount = discountedAmount.add(
                    discountRangeAmount.divide(BigDecimal.valueOf(100)).multiply(BigDecimal.valueOf(percentDiscount))
                );
                if(purchaseAmountToProcess.compareTo(new BigDecimal(0)) == 0) {
                    break;
                }
            }

        }

        return discountedAmount;
    }
}

