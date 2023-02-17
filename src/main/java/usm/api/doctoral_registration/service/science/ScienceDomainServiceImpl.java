package usm.api.doctoral_registration.service.science;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.dto.student.StudentDTO;
import usm.api.doctoral_registration.dto.student.StudyDTO;
import usm.api.doctoral_registration.model.science.ScienceDomain;
import usm.api.doctoral_registration.model.science.ScienceSchool;
import usm.api.doctoral_registration.model.student.properties.YearStudy;
import usm.api.doctoral_registration.repository.science.ScienceDomainRepository;
import usm.api.doctoral_registration.repository.student.StudentRepository;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ScienceDomainServiceImpl implements ScienceDomainService {

    private final ScienceDomainRepository domainRepository;
    private  final StudentRepository studentRepository;

    @Override
    public List<ScienceDomain> findAll() {
        return domainRepository.findAll();
    }

    @Override
    public List<ScienceDomain> findAllByScienceSchoolId(Integer scienceSchoolId) {
        return domainRepository.findAllByScienceSchoolId(scienceSchoolId);
    }

    @Override
    public List<ScienceDomain> findAllByScienceSchoolIdAndYear(Integer scienceSchoolId, Integer year) {
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

        return domainRepository.findAllByScienceSchoolAndGrade(scienceSchoolId, grade);
    }
}
