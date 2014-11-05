package org.jiaozhu.log4j;

import org.apache.log4j.Logger;



/**
 * @author jiaozhu
 * @email gitview(at)gmail.com
 * @description
 */
public class Log4jTest {

    public void testConsleAppender(){
        Logger logger = Logger.getLogger(Log4jTest.class);
        logger.error("级别信息");
        logger.info("级别信息");
        logger.debug("级别信息");
    }

    public static void main(String[] args) {
        new Log4jTest().testConsleAppender();
    }
}
