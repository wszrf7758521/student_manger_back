package org.example;

import org.example.pojo.Building;
import org.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/write")
    public String insertStr(@RequestParam("key") String key, @RequestParam("value") String value) {
        redisUtil.set(key, value);
        return "写入成功";
    }

    @GetMapping("/getStr")
    public String getStr(@RequestParam("key") String key) {
        return String.valueOf(redisUtil.get(key));
    }


    @GetMapping("/getAndSet")
    public String getAndSet(@RequestParam("key") String key, @RequestParam("value") String value) {
        return String.valueOf(redisUtil.getAndSet(key, value));
    }

    @GetMapping("/setHm")
    public void setHm(){
        Building building = new Building();
        building.setNo(1);
        building.setHeight(99);
        building.setCengshu(32);
        redisUtil.hmSet("building","building-obj",building);
    }

    @GetMapping("/getHm")
    public Object getHm(){
        return redisUtil.hmGet("building","building-obj");
    }

}
