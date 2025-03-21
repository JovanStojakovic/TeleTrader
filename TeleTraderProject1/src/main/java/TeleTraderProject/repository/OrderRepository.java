package TeleTraderProject.repository;

import TeleTraderProject.model.Order;
import TeleTraderProject.model.OrderType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
        List<Order> findByOrderType(OrderType orderType, Pageable pageable);

}
