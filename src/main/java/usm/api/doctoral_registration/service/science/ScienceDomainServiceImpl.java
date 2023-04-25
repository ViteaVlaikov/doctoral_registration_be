package usm.api.doctoral_registration.service.science;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import usm.api.doctoral_registration.dto.science.ScienceBranchDto;
import usm.api.doctoral_registration.dto.science.ScienceDomainDto;
import usm.api.doctoral_registration.dto.science.ScienceProfileDto;
import usm.api.doctoral_registration.dto.science.SpecialityDto;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.mapper.YearStudyMapper;
import usm.api.doctoral_registration.mapper.science.ScienceDomainMapper;
import usm.api.doctoral_registration.model.science.ScienceDomain;
import usm.api.doctoral_registration.model.student.properties.YearStudy;
import usm.api.doctoral_registration.repository.science.ScienceDomainRepository;
import usm.api.doctoral_registration.service.student.StudentService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ScienceDomainServiceImpl implements ScienceDomainService {

    private final ScienceDomainRepository domainRepository;
    private  final ScienceDomainMapper scienceDomainMapper;
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
    public List<ScienceDomain> findAllByScienceSchoolId(Integer scienceSchoolId) {
        return domainRepository.findAllByScienceSchoolId(scienceSchoolId);
    }

    @Override
    public List<ScienceDomainDto> findAllByScienceSchoolIdAndYear(Integer scienceSchoolId, Integer year) {
        YearStudy grade = yearStudyMapper.mapFromInteger(year);

        List<ScienceDomainDto> scienceDomainDtos = domainRepository.findAllByScienceSchoolIdAndGrade(scienceSchoolId, grade).stream()
                .map(scienceDomainMapper::toDto)
                .toList();
        setBranchDtosToDomainDtos(grade, scienceDomainDtos);

        return scienceDomainDtos;
    }

    private void setBranchDtosToDomainDtos(YearStudy grade, List<ScienceDomainDto> scienceDomainDtos) {
        for(ScienceDomainDto scienceDomainDto : scienceDomainDtos) {
            List<ScienceBranchDto> allByScienceDomainIdAndYear = scienceBranchService.findAllByScienceDomainIdAndYear(scienceDomainDto.getId(), grade);
            setProfileDtosToBranchDtos(grade, allByScienceDomainIdAndYear);
            Set<ScienceBranchDto> scienceBranchDtos = new HashSet<>(allByScienceDomainIdAndYear);
            scienceDomainDto.setScienceBranches(scienceBranchDtos);
        }
    }

    private void setProfileDtosToBranchDtos(YearStudy grade, List<ScienceBranchDto> allByScienceDomainIdAndYear) {
        for(ScienceBranchDto scienceBranchDto : allByScienceDomainIdAndYear){
            List<ScienceProfileDto> allByScienceBranchIdAndYear = scienceProfileService.findAllByScienceBranchIdAndYear(scienceBranchDto.getId(), grade);
            setSpecialityDtosToProfileDtos(grade, allByScienceBranchIdAndYear);
            Set<ScienceProfileDto> scienceProfileDtos = new HashSet<>(allByScienceBranchIdAndYear);
            scienceBranchDto.setScienceProfiles(scienceProfileDtos);
        }
    }

    private void setSpecialityDtosToProfileDtos(YearStudy grade, List<ScienceProfileDto> allByScienceBranchIdAndYear) {
        for(ScienceProfileDto scienceProfileDto : allByScienceBranchIdAndYear) {
            List<SpecialityDto> allByScienceProfileIdAndGrade = specialityService.findAllByScienceProfileIdAndGrade(scienceProfileDto.getId(), grade);
            setStudentDtosToSpecialityDtos(grade, allByScienceProfileIdAndGrade);
            Set<SpecialityDto> specialityDtos = new HashSet<>(allByScienceProfileIdAndGrade);
            scienceProfileDto.setSpecialities(specialityDtos);
        }
    }

    private void setStudentDtosToSpecialityDtos(YearStudy grade, List<SpecialityDto> allByScienceProfileIdAndGrade) {
        for(SpecialityDto specialityDto : allByScienceProfileIdAndGrade){
            List<StudentDto> allBySpecialityIdAndYear = studentService.findAllBySpecialityIdAndYear(specialityDto.getId(), grade);
            Set<StudentDto> studentDtos = new HashSet<>(allBySpecialityIdAndYear);
            specialityDto.setStudents(studentDtos);
        }
    }
}
