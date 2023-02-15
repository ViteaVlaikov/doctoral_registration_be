package usm.api.doctoral_registration.model.sciences;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "science_profile")
@Data
public class ScienceProfile {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "science_branch_id")
    private ScienceBranch scienceBranch;

    @OneToMany(mappedBy = "scienceProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Speciality> specialities = new LinkedHashSet<>();
}