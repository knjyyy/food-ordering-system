package org.rk3.service.domain.ports.output.message.publisher.payment;

import org.rk3.event.publisher.DomainEventPublisher;
import org.rk3.order.service.domain.event.OrderCancelledEvent;

public interface OrderCancelledPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCancelledEvent> {

}
