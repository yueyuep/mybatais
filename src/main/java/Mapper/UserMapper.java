package Mapper;

import Enity.User;

import java.util.List;

/**
 * Create by lp on 2019/12/19
 */
public interface UserMapper {
    public User findUserById(long id) throws Exception;

    public List<User> findUserByName(String username) throws Exception;

    public void insertUserlong(User user) throws Exception;

    public void updateUser(User user) throws Exception;
}
