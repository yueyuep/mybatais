import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import po.User;

import java.io.InputStream;
import java.util.List;

/**
 * Create by lp on 2019/12/19
 */
public class MybatisTest1 {
    @Test
    public void findById() throws Exception {
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
        String url = "mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(url);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userlist = sqlSession.selectList("test.findUserByName", "lipeng");
        System.out.println(userlist);
        sqlSession.close();
    }
}
