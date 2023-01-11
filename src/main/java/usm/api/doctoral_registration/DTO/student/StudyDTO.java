package usm.api.doctoral_registration.DTO.student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import usm.api.doctoral_registration.DTO.order.OrderDTO;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StudyDTO {

    private String registration;

    private OrderDTO orderDTO;

    private String yearStudy;

    private LocalDate beginStudies;

    private LocalDate endStudies;

    private String studyType;

    private String financing;

    private Float Speciality;         // id
}
