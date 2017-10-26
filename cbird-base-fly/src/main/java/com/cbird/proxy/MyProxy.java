package com.cbird.proxy;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
 * @Date Created in 2017年10月21日 20:31
 * @since 1.0
 */
public class MyProxy {

    public  interface  IHello {

        /**
         * 打印hello world
         * @author cuiyuhui
         * @created
         * @param
         * @return
         */
        void sayHello();
    }

    static class Hello implements  IHello {


        @Override
        public void sayHello() {
            System.out.println("Helo");
        }
    }
    static class MyInvocationHandler implements InvocationHandler {

        private Object target;

        public MyInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("插入前置代码");
            Object rs = method.invoke(this.target, args);
            System.out.println("后置代码");
            return rs;
        }
    }

    public static void main(String[] args) {
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Class proxyClass = Proxy.getProxyClass(IHello.class.getClassLoader(),IHello.class);
        try {
            Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);
            IHello iHello = (IHello) constructor.newInstance(new MyInvocationHandler(new Hello()));
            iHello.sayHello();
            Proxy pp = (Proxy) iHello;
            System.out.println("pp:" + pp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
