package com.springboot.prometeus.tacos.data;

import com.springboot.prometeus.tacos.domain.Order;

public interface OrderRepository {

    Order save(Order order);
}