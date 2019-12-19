package DaoImpl;

import DAO.UserDao;
import Enity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Create by lp on 2019/12/19
 * DAO的实现类
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;

    }

    public User findById(long id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("test.findUserById", id);
    }

    public List<User> findByUsername(String username) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("test.findUserByName", username);

    }

    public void insertUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();


    }

    public void updataUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.updateUser", user);
        sqlSession.commit();


    }
}
