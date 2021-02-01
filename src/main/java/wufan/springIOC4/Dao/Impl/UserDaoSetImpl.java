package main.java.wufan.springIOC4.Dao.Impl;


import main.java.wufan.springIOC4.Dao.UserDao;

import java.util.Date;

/**
 * 测试通过set注入对象
 */
public class UserDaoSetImpl implements UserDao {
    private String name;
    private Date birthday;
    private int age;
    private char sex;

    public String getName() {
        return name;
    }

    public void setNamea(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
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
