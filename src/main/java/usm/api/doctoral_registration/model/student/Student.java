package usm.api.doctoral_registration.model.student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

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
    private Citizenship citizenship;

    @Column(name = "diploma_series")
    private String diploma_series;

    @Column(name = "diploma_number")
    private Long diploma_number;

    @Column(name = "personal_email")
    private String personalEmail;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "registration_type")
    @Enumerated(EnumType.STRING)
    private Registration registration;

    @Column(name = "registration_order_number")
    private Long order_number;

    @Column(name = "registration_order_date")
    private Date order_date;

    @Column(name = "year_study")
    private Date year_study;

    @Column(name = "begin_studies")
    private Date begin_studies;

    @Column(name = "end_studies")
    private Date end_studies;

    @Column(name = "study")
    @Enumerated(EnumType.STRING)
    private Study study;

    @Column(name = "financing")
    @Enumerated(EnumType.STRING)
    private Financing financing;

    @Column(name = "school")
    private String school;
}