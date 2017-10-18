package com.cbird.classloader;

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
 * @Date Created in 2017年10月13日 21:38
 * @since 1.0
 */
public class Ann {
    public void sayHello() {

        System.out.println("Hello My ClassLoader is:" + this.getClass().getClassLoader() +",parent:" + this.getClass().getClassLoader().getParent());
    }
}
