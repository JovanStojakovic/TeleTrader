package TeleTraderProject.service;
import TeleTraderProject.dto.OrderDTO;
import TeleTraderProject.model.OrderType;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface OrderService {
    CompletableFuture<OrderDTO> saveOrder(OrderDTO orderDTO);
    CompletableFuture<List<OrderDTO>> getTop10Orders(String orderTypeStr);
}
