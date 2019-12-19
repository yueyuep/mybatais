package DAO;

import Enity.User;

import java.util.List;

/**
 * Create by lp on 2019/12/19
 */
public interface UserDao {
    //定义与user相关的数据访问接口
    public User findById(long id);

    public List<User> findByUsername(String username);

    public void insertUser(User user);

    public void updataUser(User user);


}
