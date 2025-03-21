package TeleTraderProject.controller;

import TeleTraderProject.dto.OrderDTO;
import TeleTraderProject.model.OrderType;
import TeleTraderProject.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<OrderDTO>> saveOrder(@RequestBody @Valid OrderDTO orderDTO) {
        return orderService.saveOrder(orderDTO)
                .thenApply(savedOrderDTO -> new ResponseEntity<>(savedOrderDTO, HttpStatus.CREATED));
    }

    @GetMapping("/top10")
    public CompletableFuture<ResponseEntity<List<OrderDTO>>> getTop10Orders(@RequestParam(value = "orderType", required = false) String orderTypeStr) {
        return orderService.getTop10Orders(orderTypeStr)
                .thenApply(orders -> ResponseEntity.ok(orders));
    }


}
