package org.rk3.service.domain.ports.output.message.publisher.restaurantapproval;

import org.rk3.event.publisher.DomainEventPublisher;
import org.rk3.order.service.domain.event.OrderPaidEvent;

public interface OrderPaidRestaurantRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
