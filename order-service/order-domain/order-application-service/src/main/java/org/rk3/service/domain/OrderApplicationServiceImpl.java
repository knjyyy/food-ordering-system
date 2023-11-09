package org.rk3.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.rk3.service.domain.dto.create.CreateOrderCommand;
import org.rk3.service.domain.dto.create.CreateOrderResponse;
import org.rk3.service.domain.dto.track.TrackOrderQuery;
import org.rk3.service.domain.dto.track.TrackOrderResponse;
import org.rk3.service.domain.ports.input.service.OrderApplicationService;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Slf4j
@Valid
@Service
class OrderApplicationServiceImpl implements OrderApplicationService {

    private final OrderCreateCommandHandler orderCreateCommandHandler;

    private final OrderTrackCommandHandler orderTrackCommandHandler;

    public OrderApplicationServiceImpl(OrderCreateCommandHandler orderCreateCommandHandler, OrderTrackCommandHandler orderTrackCommandHandler) {
        this.orderCreateCommandHandler = orderCreateCommandHandler;
        this.orderTrackCommandHandler = orderTrackCommandHandler;
    }

    @Override
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        return orderCreateCommandHandler.createOrder(createOrderCommand);
    }

    @Override
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        return orderTrackCommandHandler.trackOrder(trackOrderQuery);
    }
}
