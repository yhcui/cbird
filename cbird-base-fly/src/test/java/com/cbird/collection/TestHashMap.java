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
        String value = map.put("cc", "sb");
        System.out.println("first value:" + value);
        String sv = map.put("cc","dd");
        System.out.println("second value:" + sv);
        String ccV = map.get("cc");
        System.out.println("ccVlaue:" + ccV);
        String nullV = map.put(null, "NULL1");

        System.out.println("nullv" +  map.get(null));


    }

    @Test
    public void testThreadSafeHashHap() {
        Map<String, String> synchronizedMap = Collections.synchronizedMap(new HashMap<String,String>());

    }
}
