package customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public boolean isCustomerTypeValid(final String customerType) {
        return getAllowedCutomerTypes().contains(customerType);
    }

    private List<String> getAllowedCutomerTypes() {
        List<String> allowedCustomerTypes = new ArrayList<>();
        allowedCustomerTypes.add("Regular");
        allowedCustomerTypes.add("Premium");
        return allowedCustomerTypes;
    }
}
