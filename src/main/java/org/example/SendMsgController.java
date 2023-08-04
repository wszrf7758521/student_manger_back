package org.example;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/mq")
public class SendMsgController {

    @Autowired
    RabbitTemplate rabbitTemplate;


    @GetMapping("/sendMsg")
    public String sendDirectMsg(){
        String msgId = String.valueOf(UUID.randomUUID());
        String msgData = "test msg";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map = new HashMap<>();
        map.put("msgId",msgId);
        map.put("msgData",msgData);
        map.put("createTime",createTime);

        rabbitTemplate.convertAndSend("TestDirectExchange","TestDirectRouting",map);
        return "send success";

    }

}
