package TeleTraderProject.service.impl;

import TeleTraderProject.dto.OrderDTO;
import TeleTraderProject.model.Order;
import TeleTraderProject.model.OrderType;
import TeleTraderProject.repository.OrderRepository;
import TeleTraderProject.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static TeleTraderProject.model.OrderType.getOrderTypeFromString;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Async
    public CompletableFuture<OrderDTO> saveOrder(OrderDTO orderDTO) {
            Order order = modelMapper.map(orderDTO, Order.class);
            order.setLocalDate(LocalDate.now());
            order.setLocalTime(LocalTime.now());
            Order savedOrder = orderRepository.save(order);
            OrderDTO savedOrderDTO = modelMapper.map(savedOrder, OrderDTO.class);

            return CompletableFuture.completedFuture(savedOrderDTO);
    }

    @Override
    @Async
    public CompletableFuture<List<OrderDTO>> getTop10Orders(String orderTypeStr) {
        OrderType orderType = getOrderTypeFromString(orderTypeStr)
                .orElseThrow(() -> new IllegalArgumentException("Order type cannot be null or empty."));

        int pageSize = 10;
        int pageNumber = 0;
        List<Order> orders;

        Sort.Direction sortDirection = (orderType == OrderType.BUY) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, "price"));

        orders = orderRepository.findByOrderType(orderType, pageable);

        List<OrderDTO> top10Orders = orders.stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());

        return CompletableFuture.completedFuture(top10Orders);
    }


}
