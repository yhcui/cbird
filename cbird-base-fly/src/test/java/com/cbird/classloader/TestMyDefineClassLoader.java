package com.cbird.classloader;

import org.junit.Test;

import java.awt.color.CMMException;
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
 * @Date Created in 2017年10月13日 21:39
 * @since 1.0
 */

public class TestMyDefineClassLoader {


    /**
     * 测试内部类
     * @author cuiyuhui
     * @created
     * @param
     * @return
     */
    @Test
    public void testClassLoader() {
        ClassLoader currentClassLoader = Thread.currentThread().getContextClassLoader();
        MyDefineClassLoader myDefineClassLoader = new MyDefineClassLoader(null);
        try {
            Class<?> clazz = myDefineClassLoader.loadClass("com.cbird.classloader.Ann");
            System.out.println(Ann.class.getClassLoader().getClass().getCanonicalName());
//            Ann ann = (Ann) clazz.newInstance();
//            ann.sayHello();
            System.out.println(clazz.getClassLoader().getClass().getCanonicalName());
            Method sayHelloMethod = clazz.getMethod("sayHello");
            sayHelloMethod.invoke(clazz.newInstance());
//            Method[] methods =clazz.getMethods();
//            for (Method mm : methods) {
//                System.out.println("mm:" + mm.getName());
//                mm.invoke(clazz.newInstance());
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 单元测试，测试内部类
     * @author cuiyuhui
     * @created
     * @param
     * @return
     */
    @Test
    public void testClassLoaderInnerClass() {


//        MyDefineClassLoader myDefineClassLoader = new MyDefineClassLoader(Thread.currentThread().getContextClassLoader());
        // TODO cuiyh9 此处为什么不加Thread.currentThread().getContextClassLoader()这个就会报错
          MyDefineClassLoader myDefineClassLoader = new MyDefineClassLoader(Thread.currentThread().getContextClassLoader());
        try {
            Class clazz = myDefineClassLoader.loadClass("com.cbird.classloader.MyDefineClassLoader$Ann2");
            Method sayHelloMethod = clazz.getMethod("sayHello");
            Object obj = clazz.getConstructors()[0].newInstance(new MyDefineClassLoader());
            sayHelloMethod.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试热替换
     * @author cuiyuhui
     * @created
     * @param
     * @return
     */
    @Test
    public void testClassLoaderHotReplace() {
        MyDefineClassLoader myDefineClassLoader = new MyDefineClassLoader(null);
        for (int i=0; i<5; i++) {
            try {
                    Class cc = myDefineClassLoader.findLoadedClassBy("com.cbird.classloader.Ann");
                    if (cc != null ) {
                        System.out.println("had loader");
                    } else {
                        System.out.println("not loader");

                    }

                    Class clazz = myDefineClassLoader.loadClass("com.cbird.classloader.Ann");
                    Method sayHelloMethod = clazz.getMethod("sayHello");
                    sayHelloMethod.invoke(clazz.newInstance());
                    Thread.sleep(1000);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
