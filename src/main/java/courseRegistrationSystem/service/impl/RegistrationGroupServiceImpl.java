package courseRegistrationSystem.service.impl;

import courseRegistrationSystem.domain.RegistrationGroup;
import courseRegistrationSystem.domain.Student;
import courseRegistrationSystem.dto.RegistrationGroupDTO;
import courseRegistrationSystem.dto.StudentDTO;
import courseRegistrationSystem.repository.RegistrationGroupRepository;
import courseRegistrationSystem.service.RegistrationGroupService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RegistrationGroupServiceImpl implements RegistrationGroupService {
    @Autowired
    private RegistrationGroupRepository groupRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RegistrationGroupDTO> getAllRegistrationGroups() {
        return groupRepository.findAll().stream().map(group ->
            modelMapper.map(group,RegistrationGroupDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RegistrationGroupDTO getRegistrationGroupBy_Id(Long groupId) {
        return modelMapper.map(groupRepository.findById(groupId),RegistrationGroupDTO.class);
    }

    @Override
    public RegistrationGroupDTO addNewRegistrationGroup(RegistrationGroup group) {
        return modelMapper.map(groupRepository.save(group),RegistrationGroupDTO.class);
    }
}
