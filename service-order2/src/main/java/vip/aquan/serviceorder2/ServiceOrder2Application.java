package vip.aquan.serviceorder2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ServiceOrder2Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceOrder2Application.class, args);
    }

}
