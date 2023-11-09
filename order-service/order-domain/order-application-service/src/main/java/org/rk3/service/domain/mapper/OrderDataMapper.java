package org.rk3.service.domain.mapper;

import org.rk3.order.service.domain.entity.Order;
import org.rk3.order.service.domain.entity.OrderItem;
import org.rk3.order.service.domain.entity.Product;
import org.rk3.order.service.domain.entity.Restaurant;
import org.rk3.service.domain.dto.create.CreateOrderCommand;
import org.rk3.service.domain.dto.create.CreateOrderResponse;
import org.rk3.service.domain.dto.create.OrderAddress;
import org.rk3.valueobject.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class OrderDataMapper {
    public Restaurant createOrderCommandToRestaurant(CreateOrderCommand createOrderCommand){
        return Restaurant.builder()
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .products(createOrderCommand.getItems()
                        .stream()
                        .map(item -> new Product(new ProductId(item.getProductId())))
                        .toList())
                .build();
    }

    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand) {
        return Order.builder()
                .customerId(new CustomerId(createOrderCommand.getCustomerId()))
                .restaurantId(new RestaurantId(createOrderCommand.getRestaurantId()))
                .deliveryAddress(orderAddressToStreetAddress(createOrderCommand.getAddress()))
                .price(new Money(createOrderCommand.getPrice()))
                .items(orderItemsToOrderItemEntities(createOrderCommand.getItems()))
                .build();
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order) {
        return CreateOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .build();
    }

    private List<OrderItem> orderItemsToOrderItemEntities(List<org.rk3.service.domain.dto.create.OrderItem> items) {
        return items.stream().map(item -> OrderItem.builder()
                .product(new Product(new ProductId(item.getProductId())))
                .price(new Money(item.getPrice()))
                .quantity(item.getQuantity())
                .subtotal(new Money(item.getSubtotal()))
                .build()).toList();
    }

    private StreetAddress orderAddressToStreetAddress(OrderAddress address) {
        return new StreetAddress(UUID.randomUUID(), address.getStreet(), address.getPostalCode(), address.getCity());
    }
}
