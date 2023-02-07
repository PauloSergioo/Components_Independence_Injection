package com.components.services;

import com.components.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OrderService {
    @Autowired
    private ShippingService shippingService;
    public Double total(Order order) {

        double percentageDiscount = order.getBasic() * (order.getDiscount() / 100);
        return order.getBasic() + shippingService.shipping(order) - percentageDiscount;
    }
}
