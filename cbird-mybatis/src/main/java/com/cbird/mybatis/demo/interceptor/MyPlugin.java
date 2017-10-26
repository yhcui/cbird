package com.cbird.mybatis.demo.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

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
 * @Date Created in 2017年10月22日 23:52
 * @since 1.0
 */
/*@Intercepts({
        @Signature(
                type= Executor.class,
                method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
        )
})*/
@Intercepts({
        @Signature(type= StatementHandler.class,
                method = "prepare",
                args = {Connection.class})
})
public class MyPlugin implements Interceptor {

        Properties props = null;

        @Override
        public Object intercept(Invocation invocation) throws Throwable {
                System.out.println("this is " + MyPlugin.class.getCanonicalName());
//                System.out.println("intercept");
                Object obj =invocation.proceed();
//                System.out.println("after intercept");
                return obj;
        }

        @Override
        public Object plugin(Object o) {
//                System.out.println("plugin:" + o.getClass().getCanonicalName());
                return Plugin.wrap(o, this);
        }

        @Override
        public void setProperties(Properties properties) {
//                System.out.println("setProperties");
                this.props = properties;
        }
}
