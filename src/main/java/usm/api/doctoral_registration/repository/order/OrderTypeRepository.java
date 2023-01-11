package usm.api.doctoral_registration.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usm.api.doctoral_registration.model.order.OrderType;

@Repository
public interface OrderTypeRepository extends JpaRepository<OrderType, Integer> {
}
