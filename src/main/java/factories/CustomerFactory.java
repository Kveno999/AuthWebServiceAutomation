package factories;

import data.models.core.Customer;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomStringUtils;
import utils.RandomUtils;

@UtilityClass
public class CustomerFactory {

    public static Customer buildRandomCustomer() {
        return Customer.builder()
                .username(RandomStringUtils.randomAlphabetic(12))
                .password(RandomStringUtils.randomAlphabetic(8))
                .build();
    }

    public static Customer buildRandomCustomerWithGeorgianCredentials() {
        return Customer.builder()
                .username(RandomUtils.generateRandomGeorgianString(12))
                .password(RandomUtils.generateRandomGeorgianString(12))
                .build();
    }

}
