package usm.api.doctoral_registration.model.sciences;

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
@Table(name = "sciences_branch")
@Data
public class SciencesBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Float id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "sciencesBranch", orphanRemoval = true)
    private Set<SciencesProfile> sciencesProfiles = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "sciences_domain_id")
    private SciencesDomain sciencesDomain;

    public SciencesDomain getSciencesDomain() {
        return sciencesDomain;
    }

    public void setSciencesDomain(SciencesDomain sciencesDomain) {
        this.sciencesDomain = sciencesDomain;
    }
}