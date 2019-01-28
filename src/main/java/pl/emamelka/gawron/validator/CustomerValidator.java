package pl.emamelka.gawron.validator;

import org.springframework.stereotype.Component;
import pl.emamelka.gawron.exceptions.ValidationException;
import pl.emamelka.gawron.model.CustomerDto;

import java.util.Arrays;

@Component
public class CustomerValidator {

    private static final String[] GENDERS = {"Male", "Female"};

    public void validateCustomer(CustomerDto customerDto){
        validateGender(customerDto.getGender());
    }

    private void validateGender(String gender) {
        Arrays.stream(GENDERS)
                .filter(gen -> gen.equals(gender))
                .findAny()
                .orElseThrow(() ->
                {throw new ValidationException("Wrong gender. Available genders: " + Arrays.toString(GENDERS));
                });
    }
}
