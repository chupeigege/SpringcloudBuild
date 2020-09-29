package vip.aquan.servicemember.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.aquan.servicemember.feign.OrderFeign;
import vip.aquan.servicemember.service.MemService;

@Service
public class MemServiceImpl implements MemService {

    @Autowired
    private OrderFeign orderFeign;

    @SentinelResource(value = "memTestResource",blockHandler = "blockHandlerForMemTest")
    @Override
    public String memTest() {
        System.out.println("----进入商户实现类----");
        return orderFeign.orderTest(2);
    }

    // blockHandler 函数，原方法调用被限流/降级/系统保护的时候调用
    public String blockHandlerForMemTest(BlockException ex) {
        System.out.println(ex.getMessage());
        return "SentinelResource自定义受保护资源生效";
    }
}
