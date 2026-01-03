package com.example.cafeorder.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CafeOrderController {


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
    model.addAttribute("message", "ご注文ありがとうございます！ 選んだ商品: " + item + quantity + "点");
        return "order";
    }
}