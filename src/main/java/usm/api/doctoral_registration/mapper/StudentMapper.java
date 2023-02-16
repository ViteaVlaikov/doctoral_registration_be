package usm.api.doctoral_registration.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import usm.api.doctoral_registration.dto.student.StudentDTO;
import usm.api.doctoral_registration.model.student.Student;

@Mapper
public interface StudentMapper extends EntityMapper<Student, StudentDTO> {


    @Override
    @Mapping(target = "citizenship", source = "citizenship.country")
    StudentDTO toDto(Student entity);

    @Override
//    @Mapping(target = "citizenship", expression = "java()")
    Student toEntity(StudentDTO dto);
}
