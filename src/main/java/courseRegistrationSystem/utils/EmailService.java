package courseRegistrationSystem.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public  void sendToEmailService(String topic,String message){
        log.info("inside sendToEmailService method inside  EmailService");
        kafkaTemplate.send(topic,message);

    }
}
