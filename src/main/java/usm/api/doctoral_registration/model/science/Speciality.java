package usm.api.doctoral_registration.model.science;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import usm.api.doctoral_registration.model.student.Student;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "speciality")
public class Speciality implements Serializable {

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

    public Speciality(float i) {
        this.id = i;
    }

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