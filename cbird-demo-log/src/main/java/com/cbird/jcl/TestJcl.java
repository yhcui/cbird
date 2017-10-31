package com.cbird.jcl;

import  org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>测试使用log4j</p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author cuiyh9
 * @version 1.0
 * @Date Created in 2017年10月30日 23:12
 * @since 1.0
 */
public class TestJcl {

    private static final  Log log = LogFactory.getLog(TestJcl.class);

    public static void main(String[] args) {
        log.info("info");
        log.error("error");
    }
}
