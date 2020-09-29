package vip.aquan.serviceorder2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/test")
    public String orderTest(@RequestParam(value = "id") Integer id){

        System.out.println("----进入订单服务2.id:"+id+"----");
        return "success2";
    }
}
