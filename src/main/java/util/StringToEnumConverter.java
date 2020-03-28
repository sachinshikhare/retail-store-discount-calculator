package util;

import discount.CustomerType;
import discount.exceptions.InvalidInputException;

public class StringToEnumConverter {

    public static CustomerType convert(String customerTypeInput) {
        try {
            return CustomerType.valueOf(customerTypeInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidInputException("Invalid customer type.");
        }
    }
}
