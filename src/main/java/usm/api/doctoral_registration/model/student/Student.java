package usm.api.doctoral_registration.model.student;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import usm.api.doctoral_registration.model.country.Country;
import usm.api.doctoral_registration.model.student.properties.Gender;
import usm.api.doctoral_registration.model.student.properties.Status;
//import usm.api.doctoral_registration.model.supervisor.SteeringCommittee;
import usm.api.doctoral_registration.model.supervisor.Supervisor;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @SequenceGenerator(name = "student_sequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "corporate_email")
    private String corporateEmail;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic_name")
    private String patronymicName;

    @Column(name = "year_birth")
    private int yearBirth;

    @Column(name = "ident_number")
    private String identNumber;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country citizenship;

    @Column(name = "diploma_series")
    private String diplomaSeries;

    @Column(name = "diploma_number")
    private long diplomaNumber;

    @Column(name = "personal_email")
    private String personalEmail;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "status")
    private Status status;
    @Embedded
    private Study study;

    @Column(name = "remark")
    private String remark;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisor;

//    @OneToMany(mappedBy = "student")
//    private Set<SteeringCommittee> steeringCommittee;
}