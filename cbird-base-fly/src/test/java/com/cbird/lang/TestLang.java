package com.cbird.lang;

import org.junit.Test;

import java.math.BigDecimal;

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
 * @Date Created in 2017年10月26日 13:36
 * @since 1.0
 */
public class TestLang {

    @Test
    public void testBigDecimal() {
        BigDecimal b = new BigDecimal(1.5D);
        BigDecimal.valueOf(1.5D);
    }
}
