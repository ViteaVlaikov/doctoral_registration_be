package usm.api.doctoral_registration.model.supervisor;

import jakarta.persistence.*;
import lombok.*;
import usm.api.doctoral_registration.model.student.Student;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "steering_committee")
public class SteeringCommittee implements Serializable {

    @Getter
    @Setter
    @EqualsAndHashCode
    @Embeddable
    static class SteeringCommitteeKey implements Serializable {

        @Column(name = "student_id")
        Long studentId;

        @Column(name = "supervisor_id")
        Long supervisorId;
    }

    @EmbeddedId
    private SteeringCommitteeKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisor;
}
