package main.java.wufan.springAOP1.controller;

import main.java.wufan.springIOC4.Dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SpringAOP1beans.xml")
public class AOP1Test {
    @Autowired
     UserDao userDao = null;// new UserDaoImpl();

  /*@Before
    public static void init(){
        System.out.println("init");
        ApplicationContext ac = new ClassPathXmlApplicationContext("SpringIOC4beans.xml");
        userDao = (UserDao) ac.getBean("userDao");
    }*/

    @Test
    public void add(){
        userDao.addUser();
        System.out.println("add");
    }

    @Test
    public void add1(){
        userDao.addUser();
        System.out.println("add1");
    }

}
