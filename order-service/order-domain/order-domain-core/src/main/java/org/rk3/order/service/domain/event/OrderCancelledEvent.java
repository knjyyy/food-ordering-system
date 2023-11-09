package org.rk3.order.service.domain.event;

import org.rk3.event.DomainEvent;
import org.rk3.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderCancelledEvent  extends OrderEvent {

    public OrderCancelledEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}