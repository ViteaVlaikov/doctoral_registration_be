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
@Table(name = "order_subtype")
public class OrderSubtype implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "\"order\"")
    private String order;

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderType orderType;

    @OneToMany(mappedBy = "orderSubtype")
    private List<Order> orders;
}
