package courseRegistrationSystem.service;

import courseRegistrationSystem.domain.RegistrationGroup;
import courseRegistrationSystem.domain.Student;
import courseRegistrationSystem.dto.RegistrationGroupDTO;
import courseRegistrationSystem.dto.StudentDTO;

import java.util.List;

public interface RegistrationGroupService {

    List<RegistrationGroupDTO> getAllRegistrationGroups();
    RegistrationGroupDTO getRegistrationGroupBy_Id(Long groupId);
    RegistrationGroupDTO addNewRegistrationGroup(RegistrationGroup group);
}
