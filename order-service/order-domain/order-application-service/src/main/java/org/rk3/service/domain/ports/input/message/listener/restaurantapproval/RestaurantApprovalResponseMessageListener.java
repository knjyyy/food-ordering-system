package org.rk3.service.domain.ports.input.message.listener.restaurantapproval;

import org.rk3.service.domain.OrderCreateCommandHandler;
import org.rk3.service.domain.OrderTrackCommandHandler;
import org.rk3.service.domain.dto.message.RestaurantApprovalResponse;

public interface RestaurantApprovalResponseMessageListener  {
    void orderApproved(RestaurantApprovalResponse restaurantApprovalResponse);

    void orderRejected(RestaurantApprovalResponse restaurantApprovalResponse);
}
