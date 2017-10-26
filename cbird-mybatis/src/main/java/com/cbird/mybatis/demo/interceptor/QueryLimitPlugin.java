package com.cbird.mybatis.demo.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

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
 * @Date Created in 2017年10月23日 22:58
 * @since 1.0
 */
@Intercepts({
@Signature(type= StatementHandler.class,
method = "prepare",
args = {Connection.class})
})
public class QueryLimitPlugin implements Interceptor {

    private int limit;

    private String dbType;

    private static final String LMT_TABLE_NAME = "limit_Table_Name_xxx";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("this is " + MyPlugin.class.getCanonicalName());
        StatementHandler stmtHandler = (StatementHandler)invocation.getTarget();

        MetaObject metaStmtHandler = SystemMetaObject.forObject(stmtHandler);
        // java proxy
        while (metaStmtHandler.hasGetter("h")) {
            Object object =  metaStmtHandler.getValue("h");
            System.out.println("has getter h");
            metaStmtHandler = SystemMetaObject.forObject(object);
        }

        //cglib
        while (metaStmtHandler.hasGetter("target")) {
            Object object = metaStmtHandler.getValue("target");
            System.out.println("has getter target");
            metaStmtHandler = SystemMetaObject.forObject(object);
        }

        String sql = (String)metaStmtHandler.getValue("delegate.boundSql.sql");
        String limitSql = null;
        if ("mysql".equals(this.dbType) && sql.indexOf(LMT_TABLE_NAME) == -1) {
            sql = sql.trim();
            limitSql = "select * from (" + sql +") " + LMT_TABLE_NAME + " limit " + limit;
            metaStmtHandler.setValue("delegate.boundSql.sql", limitSql);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        String strLimit =  properties.getProperty("limit", "50");
        this.limit = Integer.parseInt(strLimit);
        this.dbType = (String) properties.getProperty("dbtype", "mysql");

    }
}
