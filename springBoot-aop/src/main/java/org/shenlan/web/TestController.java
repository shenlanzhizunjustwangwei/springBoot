package org.shenlan.web;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wangwei on 2016/9/8.
 */
@RestController
@EnableGlobalMethodSecurity
public class TestController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam String name){
        return "Hello "+name;
    }
}
