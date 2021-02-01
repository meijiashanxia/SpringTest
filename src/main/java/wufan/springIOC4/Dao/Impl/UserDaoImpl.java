package main.java.wufan.springIOC4.Dao.Impl;


import main.java.wufan.springIOC4.Dao.UserDao;

import java.util.Date;

/**
 * 测试构造函数方式注入
 */
public class UserDaoImpl implements UserDao {
    private String name;
    private Date birthday;
    private int age;
    private char sex;

    public UserDaoImpl() {
    }

    public UserDaoImpl(String name, Date birthday, int age, char sex) {
        this.name = name;
        this.birthday = birthday;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserDaoImpl{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public void addUser() {
        System.out.println("帐号添加成功！");
    }
}
