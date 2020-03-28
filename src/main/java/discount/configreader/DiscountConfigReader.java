package discount.configreader;

import discount.CustomerType;
import discount.exceptions.CustomerTypeNotConfiguredException;
import discount.exceptions.InvalidConfigException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class DiscountConfigReader {

    private static String DISCOUNT_CONFIG_FILENAME = "DiscountConfigs.properties";

    private static final String DISCOUNT_CONFIG_FILE_PATH = "./src/main/resources/";

    public static String getDiscountConfigByCustomerType(final CustomerType customerType) {

        try (InputStream configFile = new FileInputStream(DISCOUNT_CONFIG_FILE_PATH + DISCOUNT_CONFIG_FILENAME)) {
            Properties prop = new Properties();
            prop.load(configFile);
            return Optional.of(prop.getProperty(customerType.name()))
                .orElseThrow(() ->
                    new CustomerTypeNotConfiguredException(String.format("Customer type %s not configured in %s", customerType.name(), DISCOUNT_CONFIG_FILENAME))
                );

        } catch (IOException ex) {
            throw new InvalidConfigException("error while reading DiscountConfigs");
        }
    }
}
