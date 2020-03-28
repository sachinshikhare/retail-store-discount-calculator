package discount;

import discount.configreader.DiscountConfigReader;
import java.math.BigDecimal;

public class DiscountCalculatorService {

    public static final String PRICE_RANGE_KEY_ONWARDS = "onwards";
    public static final String PRICE_RANGES_SEPARATOR = ";";
    public static final String PRICE_DISCOUNT_SEPARATOR = ":";

    public BigDecimal calculateBillAmount(final CustomerType customerType, final BigDecimal purchaseAmount) {

        return purchaseAmount.subtract(this.calculateDiscountAmount(customerType, purchaseAmount));
    }

    private BigDecimal calculateDiscountAmount(final CustomerType customerType, BigDecimal purchaseAmount) {
        String discountConfig = DiscountConfigReader.getDiscountConfigByCustomerType(customerType);

        String[] pricesAndRespectiveDiscounts = discountConfig.split(PRICE_RANGES_SEPARATOR);
        BigDecimal discountedAmount = new BigDecimal(0);
        for (String priceAndRespectiveDiscount: pricesAndRespectiveDiscounts) {
            BigDecimal discountRangeAmount;
            String[] tokens = priceAndRespectiveDiscount.split(PRICE_DISCOUNT_SEPARATOR);
            if (tokens[0].equals(PRICE_RANGE_KEY_ONWARDS)) {
                discountRangeAmount = purchaseAmount;
            } else {
                discountRangeAmount = new BigDecimal(tokens[0]);
            }
            int percentDiscount = Integer.parseInt(tokens[1]);

            if (purchaseAmount.compareTo(discountRangeAmount) == -1) {
                discountedAmount = discountedAmount.add(
                    purchaseAmount.divide(BigDecimal.valueOf(100)).multiply(BigDecimal.valueOf(percentDiscount))
                );
                break;
            } else {
                purchaseAmount = purchaseAmount.subtract(discountRangeAmount);
                discountedAmount = discountedAmount.add(
                    discountRangeAmount.divide(BigDecimal.valueOf(100)).multiply(BigDecimal.valueOf(percentDiscount))
                );
                if(purchaseAmount.compareTo(new BigDecimal(0)) == 0) {
                    break;
                }
            }

        }

        return discountedAmount;
    }
}

