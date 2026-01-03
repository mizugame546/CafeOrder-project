package com.example.cafeorder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cafeorder.model.Order;
import com.example.cafeorder.repository.OrderRepository;

@Controller
public class CafeOrderController {

    private final OrderRepository orderRepository;

    public CafeOrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // 注文フォームを表示
    @GetMapping("/order")
    public String showOrderForm(Model model) {
        model.addAttribute("message", "カフェ注文フォームへようこそ！");
        return "order";
    }

    // フォームから送信された注文を保存
    @PostMapping("/order")
    public String submitOrder(
    	@RequestParam("item") String item,
    	@RequestParam(value = "quantity", defaultValue = "1") int quantity, Model model) {
        Order order = new Order();
        order.setItem(item);
        order.setQuantity(quantity);
        orderRepository.save(order);

        model.addAttribute("message", "ご注文ありがとうございます！ 選んだ商品: " + item + quantity+"点");
        return "order";
    }
}