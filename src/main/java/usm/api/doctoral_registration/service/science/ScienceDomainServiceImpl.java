package usm.api.doctoral_registration.service.science;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.dto.science.ScienceDomainDto;
import usm.api.doctoral_registration.mapper.science.ScienceDomainMapper;
import usm.api.doctoral_registration.model.science.ScienceDomain;
import usm.api.doctoral_registration.model.student.properties.YearStudy;
import usm.api.doctoral_registration.repository.science.ScienceDomainRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScienceDomainServiceImpl implements ScienceDomainService {

    private final ScienceDomainRepository domainRepository;
    private  final ScienceDomainMapper scienceDomainMapper;

    @Override
    public List<ScienceDomain> findAll() {
        return domainRepository.findAll();
    }

    @Override
    public List<ScienceDomain> findAllByScienceSchoolId(Integer scienceSchoolId) {
        return domainRepository.findAllByScienceSchoolId(scienceSchoolId);
    }

    @Override
    public List<ScienceDomainDto> findAllByScienceSchoolIdAndYear(Integer scienceSchoolId, Integer year) {
        YearStudy grade = null;
        if(year == 1)
            grade = YearStudy.I;
        if(year == 2)
            grade = YearStudy.II;
        if(year == 3)
            grade = YearStudy.III;
        if(year == 4)
            grade = YearStudy.IV;
        if(year == 5)
            grade = YearStudy.EXTRA_I;
        if(year == 6)
            grade = YearStudy.EXTRA_II;

        return domainRepository.findAllByScienceSchoolIdAndGrade(scienceSchoolId, grade).stream()
                .map(scienceDomainMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
