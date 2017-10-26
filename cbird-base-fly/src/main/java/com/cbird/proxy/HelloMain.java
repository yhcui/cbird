package com.cbird.proxy;

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
 * @Date Created in 2017年10月24日 00:29
 * @since 1.0
 */
public class HelloMain {

    public static void main(String[] args) {
        HelloServiceProxy helloHandler = new HelloServiceProxy();
        HelloService helloService = (HelloService)helloHandler.bind(new HelloServiceImpl());
        helloService.sayHello("张三");


    }

}
