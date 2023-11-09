package org.rk3.service.domain;

import lombok.extern.slf4j.Slf4j;
import org.rk3.order.service.domain.OrderDomainService;
import org.rk3.order.service.domain.entity.Customer;
import org.rk3.order.service.domain.entity.Order;
import org.rk3.order.service.domain.entity.Restaurant;
import org.rk3.order.service.domain.event.OrderCreatedEvent;
import org.rk3.order.service.domain.exception.OrderDomainException;
import org.rk3.service.domain.dto.create.CreateOrderCommand;
import org.rk3.service.domain.dto.create.CreateOrderResponse;
import org.rk3.service.domain.mapper.OrderDataMapper;
import org.rk3.service.domain.ports.output.message.publisher.payment.OrderCreatePaymentRequestMessagePublisher;
import org.rk3.service.domain.ports.output.repository.CustomerRepository;
import org.rk3.service.domain.ports.output.repository.OrderRepository;
import org.rk3.service.domain.ports.output.repository.RestaurantRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrderCreateCommandHandler {

    private final OrderCreateHelper orderCreateHelper;

    private final OrderDataMapper orderDataMapper;

    private final OrderCreatePaymentRequestMessagePublisher orderCreatePaymentRequestMessagePublisher;

    public OrderCreateCommandHandler(OrderCreateHelper orderCreateHelper, OrderDataMapper orderDataMapper,
                                     OrderCreatePaymentRequestMessagePublisher orderCreatePaymentRequestMessagePublisher) {
        this.orderCreateHelper = orderCreateHelper;
        this.orderDataMapper = orderDataMapper;
        this.orderCreatePaymentRequestMessagePublisher = orderCreatePaymentRequestMessagePublisher;
    }

    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        OrderCreatedEvent orderCreatedEvent = orderCreateHelper.persistOrder(createOrderCommand);
        log.info("Order is created with ID: {}", orderCreatedEvent.getOrder().getId().getValue());
        orderCreatePaymentRequestMessagePublisher.publish(orderCreatedEvent);
        return orderDataMapper.orderToCreateOrderResponse(orderCreatedEvent.getOrder());
    }
}
