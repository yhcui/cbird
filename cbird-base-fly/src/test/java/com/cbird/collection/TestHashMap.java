package com.cbird.collection;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
 * @Date Created in 2017年10月24日 19:51
 * @since 1.0
 */
public class TestHashMap {
    @Test
    public void testHashMap() {
        Map<String, String> map = new HashMap<>();

    }

    @Test
    public void testThreadSafeHashHap() {
        Map<String, String> synchronizedMap = Collections.synchronizedMap(new HashMap<String,String>());

    }
}
