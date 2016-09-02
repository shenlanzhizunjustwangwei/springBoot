package shenlan;

import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by wangwei on 2016/9/2.
 */
@org.springframework.boot.autoconfigure.SpringBootApplication
@EnableScheduling
public class SpringBootApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringBootApplication.class,args);
    }
}
