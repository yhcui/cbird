package com.cbird.slf4j;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>TODO</p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author cuiyh9
 * @version 1.0
 * @Date Created in 2017年10月30日 23:50
 * @since 1.0
 */
public class TestSlf4j {

    private static final Log LOG = LogFactory.getLog(TestSlf4j.class);

    public static void main(String[] args) {
        LOG.error("Test slfrj");
    }
}
