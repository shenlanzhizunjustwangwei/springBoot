package org.shenlan.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by wangwei on 2016/9/5.
 */
@RestController
public class MainController {
    @ApiIgnore
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String main(){
        return "hello";
    }
}
