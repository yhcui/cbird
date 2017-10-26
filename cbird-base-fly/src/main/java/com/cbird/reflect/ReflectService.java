package com.cbird.reflect;

import java.lang.reflect.Method;

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
 * @Date Created in 2017年10月24日 00:14
 * @since 1.0
 */
public class ReflectService {

    public void  sayHello(String name) {
        System.out.println("Hello" + name);
    }

    public static void main(String[] args) {
        Object service = null;
        try {
            service = Class.forName(ReflectService.class.getName()).newInstance();
            Method method = service.getClass().getMethod("sayHello", String.class);
            method.invoke(service, "zhangsan");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
