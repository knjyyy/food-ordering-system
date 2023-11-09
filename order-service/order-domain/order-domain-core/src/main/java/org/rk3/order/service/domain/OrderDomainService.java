package org.rk3.order.service.domain;

import org.rk3.order.service.domain.entity.Order;
import org.rk3.order.service.domain.entity.Restaurant;
import org.rk3.order.service.domain.event.OrderCancelledEvent;
import org.rk3.order.service.domain.event.OrderCreatedEvent;
import org.rk3.order.service.domain.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {
    OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant);

    OrderPaidEvent payOrder(Order order);

    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessagges);

    void cancelOrder(Order order, List<String> failureMessages);
}
