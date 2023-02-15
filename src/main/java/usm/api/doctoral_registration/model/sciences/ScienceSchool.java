package usm.api.doctoral_registration.model.sciences;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "science_school")
public class ScienceSchool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "scienceSchool", orphanRemoval = true)
    private Set<ScienceDomain> scienceDomains = new LinkedHashSet<>();
}