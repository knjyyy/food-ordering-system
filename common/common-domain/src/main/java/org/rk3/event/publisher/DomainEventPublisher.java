package org.rk3.event.publisher;

import org.rk3.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent>{
    void publish(T domainEvent);
}
