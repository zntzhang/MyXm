package com.cn.hnust.activemq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*import com.cn.hnust.activemq.controller.MqService;*/

/*@Controller
@RequestMapping("/mq")
public class MqController {

    @Autowired
    private MqService mqService;

    @RequestMapping("/send")
    public String sendMq(){
        System.out.println("发送mq消息");
        final String msg="test";
        mqService.sendMQ(msg);
        return "mqPage";
    }

}*/
