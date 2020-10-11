package vip.aquan.servicemember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * sentinel ：教程https://github.com/alibaba/spring-cloud-alibaba/wiki/Sentinel
 * 1.<dependency>
 *             <groupId>com.alibaba.cloud</groupId>
 *             <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
 *   </dependency>
 * 2.下载sentinel控制台 https://github.com/alibaba/Sentinel/releases
 * 执行命令：java -jar sentinel-dashboard-1.6.3.jar --server.port=8888
 * 3.配置sentinel控制台地址信息 application.yml
 * 4.在控制台调整参数。【默认所有的流控设置保存在内存中，重启失效】
 *
 * 5.自定义流控返回信息，详见SentinelConfig
 *
 *
 * 熔断：
 * 1.打开 Sentinel 对 Feign 的支持
 * feign:
 *   sentinel:
 *     enabled: true
 * 2.配置fallback，详见OrderFeign
 *
 * 降级：
 * 1.在Sentinel界面可配置，响应时间，异常比例等，当满足条件时，也会走熔断方法
 * 2.可在消费者配置降级，走熔断方法。也可在提供者配置降级，走流控/降级数据（但是服务调用是正常走通的）。
 *
 * 自定义受保护资源：
 * @SentinelResource
 * 定义后，同样可在界面配置熔断降级
 *
 * 可在网关层配置（网关流控）：好处，不用请求微服务就被拦截，更快响应
 *
 *
 * JMeter：
 * 1.百度JMeter下载zip，解压运行bin目录下的jmeter.bat
 * 2.添加线程组-》Http请求-》结果树、汇总、聚集报告等，填好地址，线程数，发起请求
 *
 * jvisualvm
 * 1.用cmd输入jvisualvm
 * 2.连接某个服务，即可
 * 注意：安装插件出错，需要重新指定下载的库，具体百度
 *
 * 影响性能：硬件配置、jvm配置（调整堆栈大小）、代码逻辑、sql语句（sql优化）等。
 *
 * redisson：
 * 1.导入依赖
 * <!-- https://mvnrepository.com/artifact/org.redisson/redisson -->
 * <dependency>
 *     <groupId>org.redisson</groupId>
 *     <artifactId>redisson</artifactId>
 *     <version>3.12.5</version>
 * </dependency>
 *
 * 2.配置RedissonClient
 * 3.注入即可使用，功能类似JUC
 *
 * 缓存数据一致性解决方案：
 * 双写模式（更新db，更新缓存）   失效模式（更新db，删除缓存）， 高并发可能会出现问题，导致缓存数据不一致
 * 1.给缓存定时删除，保证下次读刷新缓存（最终一致性）
 * 2.读写数据的时候，加上分布式读写锁（性能会有所影响）
 *
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ServiceMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMemberApplication.class, args);
    }

}
