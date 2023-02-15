package usm.api.doctoral_registration.model.science;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "speciality")
@Data
public class Speciality {
    @Id
    @Column(name = "id", nullable = false)
    private Float id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "science_profile_id")
    private ScienceProfile scienceProfile;
}