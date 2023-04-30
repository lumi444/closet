package infsus.closet.closet;

import infsus.closet.closet.model.OrderStatus;
import infsus.closet.closet.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order-status")
public class OrderStatusResource {

    private final OrderStatusService orderStatusService;

    @Autowired
    public OrderStatusResource(OrderStatusService orderStatusService) {
        this.orderStatusService = orderStatusService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderStatus>> getAllOrderStatus() {
        List<OrderStatus> orderStatusList = orderStatusService.findAll();
        return new ResponseEntity<>(orderStatusList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<OrderStatus> getOrderStatusById(@PathVariable Long id) {
        Optional<OrderStatus> orderStatusOptional = orderStatusService.findById(id);
        return orderStatusOptional.map(orderStatus -> new ResponseEntity<>(orderStatus, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    public ResponseEntity<OrderStatus> createOrderStatus(@RequestBody OrderStatus orderStatus) {
        OrderStatus newOrderStatus = orderStatusService.save(orderStatus);
        return new ResponseEntity<>(newOrderStatus, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrderStatus> updateOrderStatus(@PathVariable Long id, @RequestBody OrderStatus orderStatus) {
        Optional<OrderStatus> orderStatusOptional = orderStatusService.findById(id);
        if (orderStatusOptional.isPresent()) {
            orderStatus.setId(id);
            OrderStatus updatedOrderStatus = orderStatusService.save(orderStatus);
            return new ResponseEntity<>(updatedOrderStatus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrderStatus(@PathVariable Long id) {
        Optional<OrderStatus> orderStatusOptional = orderStatusService.findById(id);
        if (orderStatusOptional.isPresent()) {
            orderStatusService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

