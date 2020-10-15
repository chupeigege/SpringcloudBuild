package vip.aquan.servicemember.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.aquan.servicemember.service.MemService;

import java.util.List;

@RestController
@RequestMapping("mem")
public class MemController {
    @Autowired
    private MemService memService;

    @RequestMapping("test")
    public String orderTest(){
        List<String> menuData = memService.getMenuData();
        System.out.println(menuData);
        return memService.memTest();
    }
}
