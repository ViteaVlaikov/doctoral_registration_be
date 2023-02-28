package usm.api.doctoral_registration.model.order;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "order_subtype")
public class OrderSubtype {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "order")
    private String order;

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderType orderType;

    @OneToMany(mappedBy = "orderSubtype")
    private List<Order> orders;
}
