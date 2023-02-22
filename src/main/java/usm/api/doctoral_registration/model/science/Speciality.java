package usm.api.doctoral_registration.model.science;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import usm.api.doctoral_registration.model.student.Student;
import usm.api.doctoral_registration.model.student.Study;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "speciality")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Speciality {
    @Id
    @Column(name = "id", nullable = false)
    private Float id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "science_profile_id")
    private ScienceProfile scienceProfile;

    @ToString.Exclude
    @OneToMany(mappedBy = "speciality", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Student> students = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Speciality that = (Speciality) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}