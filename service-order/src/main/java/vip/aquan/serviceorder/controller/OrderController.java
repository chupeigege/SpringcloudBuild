package vip.aquan.serviceorder.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RedissonClient redisson;

    @RequestMapping("/test")
    public String orderTest(@RequestParam(value = "id") Integer id){
        RLock lock = redisson.getLock("my-order");
        lock.lock();//阻塞等待
        try {
            System.out.println("redisson:"+redisson);
            System.out.println("----进入订单服务.id:"+id+"----");
        }finally {
            lock.unlock();
        }
        return "success";
    }
}
