package infsus.closet.closet.repo;

import infsus.closet.closet.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepo extends JpaRepository<OrderStatus,Long> {
}
