package com.cbird.mybatis.demo;

import com.cbird.mybatis.demo.entity.City;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.net.URL;

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
 * @Date Created in 2017年10月19日 21:38
 * @since 1.0
 */
public class CityDaoTest {

    @Test
    public void test() {

        URL url = CityDaoTest.class.getClass().getResource("/mybatis-config.xml");
//        System.out.println("url:" + url.getPath());
//        System.out.println("========");
        InputStream is = CityDaoTest.class.getResourceAsStream("/mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);

        SqlSession session = factory.openSession();
        City city = session.selectOne("com.cbird.mybatis.demo.dao.CityDao.selectById", 1);

//        System.out.println("Hello World!" + city.getCityCode());
    }
}
