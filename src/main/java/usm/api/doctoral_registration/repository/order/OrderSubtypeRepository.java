package usm.api.doctoral_registration.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usm.api.doctoral_registration.dto.order.OrderSubtypeDto;
import usm.api.doctoral_registration.model.order.OrderSubtype;

@Repository
public interface OrderSubtypeRepository extends JpaRepository<OrderSubtype, Integer> {
}
