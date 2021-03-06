package Enity;

/**
 * Author:lp on 2019/12/19 10:25
 * Param:
 * return:
 * Description:po类，数据库映射的对象
 */
public class User {
    private long user_id;
    private String user_name;
    private String sex;
    private int age;

    public User() {

    }

    public User(String user_name, String sex, int age) {
        this.user_name = user_name;
        this.sex = sex;
        this.age = age;

    }

    public long getUser_id() {
        return user_id;
    }

    public String getSex() {
        return sex;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return user_id + "\t" + user_name + "\t" + sex;
    }
}
