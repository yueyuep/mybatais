package DaoImpl;

import Enity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Create by lp on 2019/12/19
 */
public class UserDaoImplTest {
    @Test
    public void start() throws Exception {
        //测试DAOImpl类的方法
        String url = "mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(url);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        UserDaoImpl userDao = new UserDaoImpl(sqlSessionFactory);
        ///测试如下

        User user=userDao.findById(2);
        System.out.println(user);


        List<User> userList=userDao.findByUsername("zhanghao");
        System.out.println(userList);


        User insertuser=new User("yuyuep","man",25);
        userDao.updataUser(insertuser);

    }

}