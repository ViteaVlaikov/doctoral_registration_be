package usm.api.doctoral_registration.model.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "type_order")
public class OrderType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_order_seq")
    @SequenceGenerator(name = "type_order_seq")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "order")
    private String typeOrder;

    @OneToMany(mappedBy = "orderType")
    private List<Order> orders;
}
