package usm.api.doctoral_registration.mapper.student;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import usm.api.doctoral_registration.dto.order.OrderDto;
import usm.api.doctoral_registration.dto.science.SpecialityDto;
import usm.api.doctoral_registration.dto.student.StudentDto;
import usm.api.doctoral_registration.mapper.EntityMapper;
import usm.api.doctoral_registration.mapper.country.CountryMapper;
import usm.api.doctoral_registration.mapper.supervisor.SupervisorMapper;
import usm.api.doctoral_registration.model.order.Order;
import usm.api.doctoral_registration.model.science.Speciality;
import usm.api.doctoral_registration.model.student.Student;

@Component
@Mapper(uses = {SupervisorMapper.class, CountryMapper.class,
        StudentMapper.OrderMapper.class, StudentMapper.SpecialityMapper.class})
public interface StudentMapper extends EntityMapper<Student, StudentDto> {

    @Mapper
    @Component
    interface OrderMapper extends EntityMapper<Order, StudentDto.OrderDto> {

        @Override
        @Mapping(source = "orderSubtype.id", target = "orderSubtypeId")
        @Mapping(source = "orderSubtype.order", target = "orderSubtype")
        @Mapping(source = "orderSubtype.orderType.id", target = "orderTypeId")
        @Mapping(source = "orderSubtype.orderType.order", target = "orderType")
        StudentDto.OrderDto toDto(Order order);

        @Override
        @Mapping(source = "orderSubtypeId", target = "orderSubtype.id")
        @Mapping(source = "orderSubtype", target = "orderSubtype.order")
        @Mapping(source = "orderTypeId", target = "orderSubtype.orderType.id")
        @Mapping(source = "orderType", target = "orderSubtype.orderType.order")
        Order toEntity(StudentDto.OrderDto orderDto);
    }

    @Mapper
    @Component
    interface SpecialityMapper extends EntityMapper<Speciality, StudentDto.SpecialityDto> {

        @Override
        @Mapping(source = "scienceProfile.name", target = "scienceProfile")
        @Mapping(source = "scienceProfile.scienceBranch.name", target = "scienceBranch")
        @Mapping(source = "scienceProfile.scienceBranch.scienceDomain.name", target = "scienceDomain")
        @Mapping(source = "scienceProfile.scienceBranch.scienceDomain.scienceSchool.id", target = "scienceSchoolId")
        @Mapping(source = "scienceProfile.scienceBranch.scienceDomain.scienceSchool.name", target = "scienceSchool")
        StudentDto.SpecialityDto toDto(Speciality speciality);

        @Override
        @Mapping(source = "scienceProfile", target = "scienceProfile.name")
        @Mapping(source = "scienceBranch", target = "scienceProfile.scienceBranch.name")
        @Mapping(source = "scienceDomain", target = "scienceProfile.scienceBranch.scienceDomain.name")
        @Mapping(source = "scienceSchoolId", target = "scienceProfile.scienceBranch.scienceDomain.scienceSchool.id")
        @Mapping(source = "scienceSchool", target = "scienceProfile.scienceBranch.scienceDomain.scienceSchool.name")
        Speciality toEntity(StudentDto.SpecialityDto specialityDto);
    }
}
