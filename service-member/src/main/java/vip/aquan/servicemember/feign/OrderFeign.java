package vip.aquan.servicemember.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 调用订单的远程服务
 */
@FeignClient(name = "service-order",fallback = OrderFeignFallback.class)
@Component
public interface OrderFeign {

    @RequestMapping("/order/test")
    String orderTest(@RequestParam(value = "id") Integer id);

}

@Component
class OrderFeignFallback implements OrderFeign{

    @Override
    public String orderTest(Integer id) {
        return "远程服务出错，熔断";
    }
}
