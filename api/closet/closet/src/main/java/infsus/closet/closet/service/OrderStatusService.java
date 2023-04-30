package infsus.closet.closet.service;

import infsus.closet.closet.model.OrderStatus;
import infsus.closet.closet.repo.OrderStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderStatusService {

    private final OrderStatusRepo orderStatusRepository;

    @Autowired
    public OrderStatusService(OrderStatusRepo orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    public List<OrderStatus> findAll() {
        return orderStatusRepository.findAll();
    }

    public Optional<OrderStatus> findById(Long id) {
        return orderStatusRepository.findById(id);
    }

    public OrderStatus save(OrderStatus orderStatus) {
        return orderStatusRepository.save(orderStatus);
    }

    public void deleteById(Long id) {
        orderStatusRepository.deleteById(id);
    }

    public void delete(OrderStatus orderStatus) {
        orderStatusRepository.delete(orderStatus);
    }
}
