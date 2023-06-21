package usm.api.doctoral_registration.service.science;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.dto.science.ScienceDomainDto;
import usm.api.doctoral_registration.mapper.YearStudyMapper;
import usm.api.doctoral_registration.mapper.science.ScienceDomainMapper;
import usm.api.doctoral_registration.repository.science.ScienceDomainRepository;
import usm.api.doctoral_registration.service.student.StudentService;

import java.util.List;

@Service
@AllArgsConstructor
public class ScienceDomainServiceImpl implements ScienceDomainService {

    private final ScienceDomainRepository domainRepository;

    private final ScienceDomainMapper scienceDomainMapper;

    private final ScienceBranchService scienceBranchService;

    private final ScienceProfileService scienceProfileService;

    private final SpecialityService specialityService;

    private final StudentService studentService;

    private final YearStudyMapper yearStudyMapper;

    @Override
    public List<ScienceDomainDto> findAll() {
        return domainRepository.findAll().stream()
                .map(scienceDomainMapper::toDto)
                .toList();
    }

    @Override
    public List<ScienceDomainDto> findAllByScienceSchoolId(Integer id) {
        return domainRepository.findAllByScienceSchoolId(id).stream()
                .map(scienceDomainMapper::toDto)
                .toList();
    }

}
