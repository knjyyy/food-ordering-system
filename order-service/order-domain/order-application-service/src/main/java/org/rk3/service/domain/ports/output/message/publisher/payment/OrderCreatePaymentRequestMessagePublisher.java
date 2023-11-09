package org.rk3.service.domain.ports.output.message.publisher.payment;

import org.rk3.event.publisher.DomainEventPublisher;
import org.rk3.order.service.domain.event.OrderCreatedEvent;

public interface OrderCreatePaymentRequestMessagePublisher extends DomainEventPublisher<OrderCreatedEvent> {

}
