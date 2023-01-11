package usm.api.doctoral_registration.model.student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;
import usm.api.doctoral_registration.model.sciences.Science;
import usm.api.doctoral_registration.model.sciences.SciencesBranch;

@Data
@Entity
@Table(name = "supervisor")
public class Supervisor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    String first_name;
    String last_name;
    String post;
    String academician = "";

    @ManyToOne
    @JoinColumn(name = "science_id")
    private Science sciences;


}