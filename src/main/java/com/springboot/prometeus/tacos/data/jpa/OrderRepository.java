package com.springboot.prometeus.tacos.data.jpa;

import com.springboot.prometeus.tacos.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}