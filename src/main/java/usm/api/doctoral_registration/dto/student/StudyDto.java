package usm.api.doctoral_registration.dto.student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import usm.api.doctoral_registration.dto.order.OrderDto;
import usm.api.doctoral_registration.dto.science.SpecialityDto;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StudyDto {

    private String registration;

    private OrderDto orderDTO;

    private String yearStudy;

    private LocalDate beginStudies;

    private LocalDate endStudies;

    private String studyType;

    private String financing;

//    private SpecialityDto Speciality;         // id
}
