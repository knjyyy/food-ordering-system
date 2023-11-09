package org.rk3.service.domain.ports.output.repository;

import org.rk3.order.service.domain.entity.Order;
import org.rk3.valueobject.TrackingId;

import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);

    Optional<Order> findByTrackingId(TrackingId trackingId);
}
