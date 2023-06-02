package com.ecommerce.posgrado.service;

import com.ecommerce.posgrado.entity.OrderEntity;
import com.ecommerce.posgrado.entity.OrderItemsEntity;
import com.ecommerce.posgrado.entity.OrderStateEnum;
import com.ecommerce.posgrado.entity.UserEntity;
import com.ecommerce.posgrado.exception.AppHandleException;
import com.ecommerce.posgrado.repository.OrderRepository;
import com.ecommerce.posgrado.request.OrderRequest;
import com.ecommerce.posgrado.response.OrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author gclaure Gustavo Claure Flores
 * Date: 5/21/23
 * Time: 00:43
 * Project Name: posgrado
 */
@Service
public class OrderImplementService implements OrderInterfaceService {

    private final OrderRepository orderRepository;

    private final ProductInterfaceService productInterfaceService;

    public OrderImplementService(OrderRepository orderRepository,
                                 ProductInterfaceService productInterfaceService) {
        this.orderRepository = orderRepository;
        this.productInterfaceService = productInterfaceService;
    }

    @Override
    public String createNewOrder(OrderRequest request) {
        OrderEntity order = new OrderEntity();
        order.setComment(request.getComment());

        List<OrderItemsEntity> items = request.getItems().stream().map((itemDto) -> {
            OrderItemsEntity item = new OrderItemsEntity();
            item.setQuantity(itemDto.getQuantity());
            item.setProduct(this.productInterfaceService.getById(itemDto.getProductId()));
            item.setOrder(order);
            return item;
        }).collect(Collectors.toList());

        order.setItems(items);

        UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        order.setDate(LocalDateTime.now());
        order.setState(OrderStateEnum.PENDING);
        order.setUser(user);

        this.orderRepository.save(order);
        return "Order saved successfully";

    }

    @Override
    public OrderResponse getById(UUID id) {
        OrderEntity order = this.orderRepository.findById(id)
                .orElseThrow(() -> new AppHandleException("order not fount", HttpStatus.NOT_FOUND));

        return OrderResponse
                .builder()
                .comment(order.getComment())
                .state(order.getState())
                .totalPrice(this.orderRepository
                        .getTotalPrice(order.getId().toString()))
                .items(this.orderRepository.getItemsWithTotalPrice(order.getId()))
                .build();
    }
}
