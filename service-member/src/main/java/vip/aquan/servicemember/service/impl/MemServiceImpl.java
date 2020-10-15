package vip.aquan.servicemember.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import vip.aquan.servicemember.feign.OrderFeign;
import vip.aquan.servicemember.service.MemService;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 获取菜单数据（用于测试SpringCache），key直接写字符串需要加单引号'
     * 查询出数据时，自动将数据放进缓存
     * @return
     */
//    @CacheEvict(value = {"menu"},key = "#root.methodName") 更新数据时清除缓存
//    @CacheEvict(value = "menu",allEntries = true) 删除menu分区（文件夹）下的所有数据
//    @CachePut 将数据放入缓存  方法要有返回值才可以
//    @Caching 支持组合操作
    @Cacheable(value = {"menu"},key = "#root.methodName")
    @Override
    public List<String> getMenuData(){
        System.out.println("----getMenuData----");

        List<String> list = new ArrayList<>();
        list.add("用户管理");
        list.add("订单管理");
        list.add("会员管理");

        return list;
    }

    // blockHandler 函数，原方法调用被限流/降级/系统保护的时候调用
    public String blockHandlerForMemTest(BlockException ex) {
        System.out.println(ex.getMessage());
        return "SentinelResource自定义受保护资源生效";
    }
}
