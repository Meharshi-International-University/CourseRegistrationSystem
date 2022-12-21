package courseRegistrationSystem.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "feignRegister",url = "http://localhost:8080/registration-requests")
public interface FeignServiceUtil {

}
