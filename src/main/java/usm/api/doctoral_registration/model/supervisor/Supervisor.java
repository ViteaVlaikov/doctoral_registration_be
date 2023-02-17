package usm.api.doctoral_registration.model.supervisor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import usm.api.doctoral_registration.model.science.ScienceSchool;
import usm.api.doctoral_registration.model.student.Student;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "supervisor")
public class Supervisor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    String firstName;
    String lastName;
    String post;
    String academician = "";

    @ManyToOne
    @JoinColumn(name = "science_school_id")
    private ScienceSchool sciences;

    @OneToMany(mappedBy = "supervisor", orphanRemoval = true)
    private Set<Student> students = new LinkedHashSet<>();

//    @OneToMany(mappedBy = "supervisor")
//    Set<SteeringCommittee> steeringCommittee;
}