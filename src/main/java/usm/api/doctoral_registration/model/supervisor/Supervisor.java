package usm.api.doctoral_registration.model.supervisor;

import jakarta.persistence.*;
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

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "post")
    private String post;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "academician")
    private String academician;

    @ManyToOne
    @JoinColumn(name = "science_school_id")
    private ScienceSchool scienceSchool;

    @OneToMany(mappedBy = "supervisor", orphanRemoval = true)
    private Set<Student> students = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "steeringCommittee")
    private Set<Student> steeringCommittee;
}