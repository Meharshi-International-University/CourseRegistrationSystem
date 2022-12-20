package courseRegistrationSystem.validation;

import courseRegistrationSystem.dto.RegistrationRequestDTO;
import courseRegistrationSystem.dto.RegistrationRequestListDTO;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;


import java.util.HashSet;

@Component
@Slf4j
public class RegistrationRequestListValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return RegistrationRequestListDTO.class.equals(clazz);
    }

    @Autowired
    private RegistrationRequestValidator registrationRequestValidator;

    @InitBinder("registrationRequest")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(registrationRequestValidator);

    }
    @Override
    public void validate(Object target, Errors errors) {
    log.info("Inside validate method of RegistrationRequestListValidator");
        RegistrationRequestListDTO registrationRequestListDTO = (RegistrationRequestListDTO) target;
        ValidationUtils.rejectIfEmpty(errors, "studentId", "studentId.errors", "Student Id is required");

        registrationRequestListDTO.getRegistrationRequestDTOList().stream()
                .dropWhile(new HashSet<>()::add)
                .findFirst()
                .ifPresent(dup -> {
                   throw new IllegalArgumentException("Duplicate Course Offerring Found: " + dup.getCourseOfferringId());
                });

//        registrationRequestListDTO.getRegistrationRequestDTOList().forEach(
//                registrationRequest ->
//                        registrationRequestValidator.validate(registrationRequest,errors)
//        );

    }
}
