package org.rk3.service.domain;

import org.junit.jupiter.api.TestInstance;
import org.rk3.service.domain.dto.create.CreateOrderCommand;
import org.rk3.service.domain.mapper.OrderDataMapper;
import org.rk3.service.domain.ports.input.service.OrderApplicationService;
import org.rk3.service.domain.ports.output.repository.CustomerRepository;
import org.rk3.service.domain.ports.output.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = OrderTestConfiguration.class)
public class OrderApplicationServiceTest {

    @Autowired
    private OrderApplicationService orderApplicationService;

    @Autowired
    private OrderDataMapper orderDataMapper;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private CreateOrderCommand createOrderCommand;
    private CreateOrderCommand createOrderCommandWrongPrice;
    private CreateOrderCommand createOrderCommandWrongProductPrice;
}
