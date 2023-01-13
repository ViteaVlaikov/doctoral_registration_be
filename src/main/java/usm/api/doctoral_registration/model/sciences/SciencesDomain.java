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

@Entity
@Table(name = "sciences_domain")
@Data
public class SciencesDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Float id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "sciencesDomain", orphanRemoval = true)
    private Set<SciencesBranch> sciencesBranches = new LinkedHashSet<>();

}