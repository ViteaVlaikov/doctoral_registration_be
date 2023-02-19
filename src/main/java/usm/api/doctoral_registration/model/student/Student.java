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
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import usm.api.doctoral_registration.model.country.Country;
import usm.api.doctoral_registration.model.science.Speciality;
import usm.api.doctoral_registration.model.student.properties.Gender;
import usm.api.doctoral_registration.model.student.properties.Status;
import usm.api.doctoral_registration.model.supervisor.Supervisor;

import java.util.Objects;

//import usm.api.doctoral_registration.model.supervisor.SteeringCommittee;

@Entity
@Table(name = "student")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
    @ToString.Exclude
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

    @ManyToOne
    @JoinColumn(name = "speciality", insertable = false, updatable = false)
    private Speciality speciality;


//    @OneToMany(mappedBy = "student")
//    private Set<SteeringCommittee> steeringCommittee;

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