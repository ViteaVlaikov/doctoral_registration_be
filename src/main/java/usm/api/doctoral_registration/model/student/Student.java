package usm.api.doctoral_registration.model.student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import usm.api.doctoral_registration.model.school.Speciality;

import java.util.Date;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @Column(name = "corporate_email", nullable = false)
    private String corporateEmail;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic_name")
    private String patronymicName;

    @Column(name = "ident_number")
    private String identNumber;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "citizenship")
    @Enumerated(EnumType.STRING)
    private Country citizenship;

    @Column(name = "diploma_series")
    private String diplomaSeries;

    @Column(name = "diploma_number")
    private Long diplomaNumber;

    @Column(name = "personal_email")
    private String personalEmail;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "registration_type")
    @Enumerated(EnumType.STRING)
    private Registration registration;

    @Column(name = "registration_order_number")
    private Long orderNumber;

    @Column(name = "registration_order_date")
    private Date orderDate;

    @Column(name = "year_study")
    private Integer yearStudy;

    @Column(name = "begin_studies")
    private Date beginStudies;

    @Column(name = "end_studies")
    private Date endStudies;

    @Column(name = "study")
    @Enumerated(EnumType.STRING)
    private Study study;

    @Column(name = "financing")
    @Enumerated(EnumType.STRING)
    private Financing financing;

    @OneToOne(mappedBy = "student", orphanRemoval = true)
    private Speciality speciality;
}