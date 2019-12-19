package Mapper;

import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Create by lp on 2019/12/19
 */
public class UserMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setup() throws Exception {
        String url = "mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(url);
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    @Test
    public void start() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过getMapper代理实现我们mapper接口的实现
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.findUserByName("yueyuep"));

    }

}