package usm.api.doctoral_registration.mapper.student;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.mapper.country.CountryMapper;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.mapper.StudyMapper;
import usm.api.doctoral_registration.mapper.supervisor.SupervisorMapper;
import usm.api.doctoral_registration.model.student.Student;

@Component
@Mapper(uses = {StudyMapper.class, SupervisorMapper.class, CountryMapper.class})
public interface StudentMapper extends EntityMapper<Student, StudentDto> {


    @Override
//    @Mapping(target = "citizenship", source = "citizenship.country")
//    @Mapping(target = "steeringCommittee", source = "steeringCommittee.")
    @Mapping(target = "study", source = "study")
    @Mapping(target = "specialityId", source = "speciality.id")
    StudentDto toDto(Student entity);

    @Override
//    @Mapping(target = "citizenship", expression = "")
    @Mapping(source = "study", target = "study")
    @Mapping(source = "specialityId", target = "speciality.id")
    Student toEntity(StudentDto dto);
}
