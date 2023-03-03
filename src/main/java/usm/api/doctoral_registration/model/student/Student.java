package usm.api.doctoral_registration.model.student;

import jakarta.persistence.Column;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import usm.api.doctoral_registration.model.country.Country;
import usm.api.doctoral_registration.model.order.Order;
import usm.api.doctoral_registration.model.science.Speciality;
import usm.api.doctoral_registration.model.student.properties.Financing;
import usm.api.doctoral_registration.model.student.properties.Gender;
import usm.api.doctoral_registration.model.student.properties.Registration;
import usm.api.doctoral_registration.model.student.properties.Status;
import usm.api.doctoral_registration.model.student.properties.StudyType;
import usm.api.doctoral_registration.model.student.properties.YearStudy;
import usm.api.doctoral_registration.model.supervisor.SteeringCommittee;
import usm.api.doctoral_registration.model.supervisor.Supervisor;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "status")
    private Status status;

    // transfer without study :

    @Enumerated(EnumType.STRING)
    @Column(name = "registration_type")
    private Registration registration;

    @ToString.Exclude
    @OneToMany(mappedBy = "student",
            cascade = jakarta.persistence.CascadeType.ALL,
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

    // end

    @Column(name = "remark")
    private String remark;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private Supervisor supervisor;

    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "speciality")
    private Speciality speciality;

    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    private Set<SteeringCommittee> steeringCommittee;

    @Column(name = "science_topic")
    private String scienceTopic;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return id != null && Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}