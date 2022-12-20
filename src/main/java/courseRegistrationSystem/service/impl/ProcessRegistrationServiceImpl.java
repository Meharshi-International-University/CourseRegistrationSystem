package courseRegistrationSystem.service.impl;

import courseRegistrationSystem.repository.StudentRepository;
import courseRegistrationSystem.service.ProcessRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProcessRegistrationServiceImpl implements ProcessRegistrationService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public void processRegistration() {

        //select student based on registration event and group




    }
}
