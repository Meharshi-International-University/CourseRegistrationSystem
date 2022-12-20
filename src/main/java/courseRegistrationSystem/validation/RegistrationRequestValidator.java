package courseRegistrationSystem.validation;

import courseRegistrationSystem.dto.RegistrationRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
@Slf4j
public class RegistrationRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return RegistrationRequestDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        log.info("inside validate method of RegistrationRequestValidator");
        RegistrationRequestDTO registrationRequestDTO = (RegistrationRequestDTO) target;
        ValidationUtils.rejectIfEmpty(errors, "priorityNumber", "priorityNumber.errors", "Priority Number is required");

    }


}
