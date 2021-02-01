package main.java.wufan.springIOC4.controller;


import main.java.wufan.springIOC4.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;
    @Autowired
    PropertiesFactoryBean pro;

    /**
     * 依赖注入
     * @param args
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        ApplicationContext ac = new ClassPathXmlApplicationContext("SpringIOC4beans.xml");
        UserController userController = (UserController) ac.getBean("userController");
        System.out.println("userController.userDaoImpl = " + userController.userDao);
        System.out.println("userController.PropertiesFactoryBean = " + userController.pro);


    }
}
