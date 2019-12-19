import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import Enity.User;

import java.io.InputStream;
import java.util.List;

/**
 * Create by lp on 2019/12/19
 */
public class MybatisTest1 {
    @Test
    public void findById() throws Exception {
        //通过id来查找
        String url = "mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(url);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById", 1);
        System.out.println(user);
        sqlSession.close();


    }

    @Test
    public void findByLikeName() throws Exception {
        //近似查找
        String url = "mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(url);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userlist = sqlSession.selectList("test.findUserByName", "lipeng");
        System.out.println(userlist);
        sqlSession.close();
    }

    @Test
    public void insertUser() throws Exception {
        //插入数据
        String url = "mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(url);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUser_name("yueyuep");
        user.setSex("man");
        user.setAge(25);
        sqlSession.insert("test.insertUser", user);
        //事务操作
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser() throws Exception {
        //插入数据
        String url = "mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(url);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUser_id(1);
        user.setUser_name("www.yuyue.group");
        user.setSex("woman");
        user.setAge(1);
        sqlSession.update("test.updateUser", user);
        //事务操作
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() throws Exception {
        //插入数据
        String url = "mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(url);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.delete("test.deleteUser", "www.yuyue.group");
        //事务操作
        sqlSession.commit();
        sqlSession.close();
    }
}
