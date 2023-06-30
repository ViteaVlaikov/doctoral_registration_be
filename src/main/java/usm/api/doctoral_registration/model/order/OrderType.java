package usm.api.doctoral_registration.model.order;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_type")
public class OrderType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "order")
    private String order;

    @OneToMany(mappedBy = "orderType")
    private List<OrderSubtype> orderSubtypes;
}
