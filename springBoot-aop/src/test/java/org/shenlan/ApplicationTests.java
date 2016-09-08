package org.shenlan;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wangwei on 2016/9/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
public class ApplicationTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test()throws Exception{
        logger.info("输出info");
        logger.debug("输出debug");
        logger.error("输出error");
    }
}
