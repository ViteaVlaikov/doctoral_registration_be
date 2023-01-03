package usm.api.doctoral_registration.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "new_entity")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class NewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        NewEntity newEntity = (NewEntity) o;
        return id != null && Objects.equals(id, newEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}