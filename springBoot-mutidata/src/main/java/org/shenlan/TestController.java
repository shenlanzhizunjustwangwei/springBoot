package org.shenlan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by wangwei on 2016/9/6.
 */
@RestController
@RequestMapping("/home")
public class TestController {
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    JdbcTemplate jdbcTemplate2;

    @RequestMapping("/test1")
    public String test1(){
        List<Map<String,Object>> list = jdbcTemplate1.queryForList("select * from user");
        return Arrays.asList(list).toString();
    }

    @RequestMapping("/test2")
    public String test2(){
        List<Map<String,Object>> list = jdbcTemplate2.queryForList("SELECT * from USER");
        return Arrays.asList(list).toString();
    }
}
