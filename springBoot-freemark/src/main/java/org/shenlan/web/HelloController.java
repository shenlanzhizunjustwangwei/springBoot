package org.shenlan.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangwei on 2016/9/9.
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "freemarker");
        return "index";
    }

    @RequestMapping("/th")
    public String index1(ModelMap map) {
        map.addAttribute("host", "thymeleaf");
        return "index1";
    }

    @RequestMapping("/vm")
    public String index2(ModelMap map) {
        map.addAttribute("host", "velocity");
        return "index2";
    }
    @RequestMapping("/jsp")
    public String index3(ModelMap map) {
        map.addAttribute("host", "jsp测试");
        return "indexj";
    }

}
