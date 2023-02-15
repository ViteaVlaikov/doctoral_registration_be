package usm.api.doctoral_registration.model.science;

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

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "science_domain")
@Data
public class ScienceDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "science_school_id")
    private ScienceSchool scienceSchool;

    @OneToMany(mappedBy = "scienceDomain", orphanRemoval = true)
    private Set<ScienceBranch> scienceBranches = new LinkedHashSet<>();

}