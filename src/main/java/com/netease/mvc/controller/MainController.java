package com.netease.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 包:        com.netease.mvc.controller
 * 类名称:     MainController
 * 类描述:     1
 * 创建人:     huangyang
 * 创建时间:   2020/12/7 9:06 上午
 */
@Controller
@RequestMapping(value = "/hy")
public class MainController {


    private final static AtomicInteger NUM = new AtomicInteger(0);

    @RequestMapping(value = "/what.do")
    @ResponseBody
    public String what() {

        System.out.println(NUM.incrementAndGet() + " what world...");
        return "what success";
    }

    // 走 Agent 代理时开启此注解, 让 Agent 注入 RestTemplate
//    @Autowired
//    RestTemplate template;

    @Autowired
    private HyMvcServiceImpl hyMvcService;

    @RequestMapping(value = "/hello.do")
    @ResponseBody
    public String hello() {

        RestTemplate template = new RestTemplate();
//        ResponseEntity<String> responseEntity = template.getForEntity("http://localhost:8760/hello", String.class);
//        if (HttpStatus.OK.equals(responseEntity.getStatusCode())) {
//            System.out.println(responseEntity.getBody());
//        }

        String str = template.getForObject("http://hy-nsf-demo-stock-provider/echo", String.class);
        System.out.println(str);
        return "hello success";
    }

    @RequestMapping(value = "/say.do")
    @ResponseBody
    public String say() {

        return hyMvcService.hello();
    }
}
