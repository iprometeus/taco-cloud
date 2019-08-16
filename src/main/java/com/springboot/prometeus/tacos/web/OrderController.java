package com.springboot.prometeus.tacos.web;

import com.springboot.prometeus.tacos.data.OrderRepository;
import com.springboot.prometeus.tacos.data.jpa.UserRepository;
import com.springboot.prometeus.tacos.domain.Order;
import com.springboot.prometeus.tacos.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;

    private UserRepository userRepository;

    public OrderController(OrderRepository orderRepo, UserRepository userRepository) {

        this.orderRepo = orderRepo;
        this.userRepository = userRepository;
    }

    @GetMapping("/current")
    public String orderForm() {

        return "orderForm";
    }

    @PostMapping
    public String processOrder(/*@Valid */Order order, Errors errors,
                                          SessionStatus sessionStatus,
                                          @AuthenticationPrincipal
                                                  User user) {

        if (errors.hasErrors()) {
            return "orderForm";
        }

        order.setUser(user);
        orderRepo.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}