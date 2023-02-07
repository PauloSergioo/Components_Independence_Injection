package com.components.services;

import com.components.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public Double shipping(Order order) {

        if(order.getBasic() < 100) {
            return 20.0;
        } else if (order.getBasic() < 200) {
            return 12.0;
        } else {
            return 0.0;
        }
    }
}
