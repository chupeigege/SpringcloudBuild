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
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ServiceMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMemberApplication.class, args);
    }

}
