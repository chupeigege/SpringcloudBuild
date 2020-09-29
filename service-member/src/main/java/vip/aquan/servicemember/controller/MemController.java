package vip.aquan.servicemember.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.aquan.servicemember.service.MemService;

@RestController
@RequestMapping("mem")
public class MemController {
    @Autowired
    private MemService memService;

    @RequestMapping("test")
    public String orderTest(){

        return memService.memTest();
    }
}
