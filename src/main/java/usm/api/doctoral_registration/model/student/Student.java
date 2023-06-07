package usm.api.doctoral_registration.model.student;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import usm.api.doctoral_registration.model.country.Country;
import usm.api.doctoral_registration.model.order.Order;
import usm.api.doctoral_registration.model.science.Speciality;
import usm.api.doctoral_registration.model.student.properties.*;
import usm.api.doctoral_registration.model.supervisor.Supervisor;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @SequenceGenerator(name = "student_sequence", allocationSize = 1)
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

    @ToString.Exclude
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

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "registration_type")
    private Registration registration;

    @ToString.Exclude
    @OneToMany(mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Order> orders;

    @Enumerated(EnumType.STRING)
    @Column(name = "year_study")
    private YearStudy yearStudy;

    @Column(name = "begin_studies")
    private LocalDate beginStudies;

    @Column(name = "end_studies")
    private LocalDate endStudies;

    @Enumerated(EnumType.STRING)
    @Column(name = "study")
    private StudyType studyType;

    @Enumerated(EnumType.STRING)
    @Column(name = "financing")
    private Financing financing;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisor;

    @ManyToOne
    @JoinColumn(name = "speciality")
    private Speciality speciality;

    @ManyToMany
    @ToString.Exclude
    @JoinTable(
            name = "steering_committee",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "supervisor_id"))
    private Set<Supervisor> steeringCommittee;

    @Column(name = "science_topic")
    private String scienceTopic;

    @Column(name = "remark")
    private String remark;
}