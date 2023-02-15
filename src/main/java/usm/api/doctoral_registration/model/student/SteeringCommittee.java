package usm.api.doctoral_registration.model.student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import usm.api.doctoral_registration.model.supervisor.Supervisor;

import java.io.Serializable;

@Data
@Entity
@Table(name = "steering_committee")
public class SteeringCommittee implements Serializable {


    @Column(name = "student_id")
    private Student student;

    @Column(name = "supervisor_id")
    private Supervisor supervisor;
}
