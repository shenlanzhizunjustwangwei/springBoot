package shenlan.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by wangwei on 2016/9/2.
 */
@Component
public class Task {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Scheduled(cron="*/3 * * * * *")
    public void reportCurrentTime(){
        //每三秒打印一行log
        System.out.println("-------------------------------------");
        logger.info("======================");
    }
}
