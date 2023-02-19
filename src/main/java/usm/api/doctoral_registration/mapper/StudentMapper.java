package usm.api.doctoral_registration.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.model.student.Student;

@Component
@Mapper(uses = {StudyMapper.class, SupervisorMapper.class, CountryMapper.class})
public interface StudentMapper extends EntityMapper<Student, StudentDto> {


    @Override
//    @Mapping(target = "citizenship", source = "citizenship.country")
//    @Mapping(target = "steeringCommittee", source = "steeringCommittee.")
//    @Mapping(target = "studyDTO", source = "study")
    StudentDto toDto(Student entity);

    @Override
//    @Mapping(target = "citizenship", expression = "")
    Student toEntity(StudentDto dto);
}
