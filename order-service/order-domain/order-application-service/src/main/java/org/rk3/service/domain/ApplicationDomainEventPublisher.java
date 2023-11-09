package org.rk3.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.rk3.event.publisher.DomainEventPublisher;
import org.rk3.order.service.domain.event.OrderCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationDomainEventPublisher implements ApplicationEventPublisherAware,
        DomainEventPublisher<OrderCreatedEvent> {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void publish(OrderCreatedEvent domainEvent) {
        this.applicationEventPublisher.publishEvent(domainEvent);
        log.info("OrderCreatedEvent is published for Order ID: {}", domainEvent.getOrder().getId().getValue());
    }
}
