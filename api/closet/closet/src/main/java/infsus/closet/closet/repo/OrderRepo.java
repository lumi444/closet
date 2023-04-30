package infsus.closet.closet.repo;

import infsus.closet.closet.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {
}
