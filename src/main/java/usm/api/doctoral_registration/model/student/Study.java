package usm.api.doctoral_registration.model.student;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import usm.api.doctoral_registration.model.order.Order;
import usm.api.doctoral_registration.model.sciences.Speciality;

import java.time.LocalDate;
import java.util.List;

@Embeddable
public class Study {
    @Column(name = "registration_type")
    @Enumerated(EnumType.STRING)
    private Registration registration;

    @OneToMany(mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Order> orders;

    @Column(name = "year_study")
    @Enumerated(EnumType.STRING)
    private YearStudy yearStudy;

    @Column(name = "begin_studies")
    private LocalDate beginStudies;

    @Column(name = "end_studies")
    private LocalDate endStudies;

    @Column(name = "study")
    @Enumerated(EnumType.STRING)
    private StudyType studyType;

    @Column(name = "financing")
    @Enumerated(EnumType.STRING)
    private Financing financing;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "speciality",
            referencedColumnName = "id")
    private Speciality speciality;
}