package usm.api.doctoral_registration.model.supervisor;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import usm.api.doctoral_registration.model.student.Student;

import java.io.Serializable;

@Data
@Entity
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
