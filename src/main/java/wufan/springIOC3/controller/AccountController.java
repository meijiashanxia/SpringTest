package main.java.wufan.springIOC3.controller;

import main.java.wufan.springIOC3.Dao.AccountDao;
import main.java.wufan.springIOC3.service.IAccountService;
import main.java.wufan.springIOC3.factory.JavaBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AccountController {

    /**
     * 获取spring 核心容器对象 并根据ID获取bean
     * @param args
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        ApplicationContext ac = new ClassPathXmlApplicationContext("SpringIOC3beans.xml");
        //根据ID获取bean
        IAccountService iAccountService;
       // AccountDao accountDao;
        AccountDao staticaccountDao;

        JavaBeanFactory factory;

        for (int i = 0; i < 5; i++) {
            iAccountService = (IAccountService) ac.getBean("accountService");
            //accountDao= (AccountDao) ac.getBean("accountDao");
            staticaccountDao= (AccountDao) ac.getBean("staticaccountDao");
            System.out.println("iAccountService = " + iAccountService);
            //System.out.println("BeanFactory      accountDao = " + accountDao);
            System.out.println("BeanFactory      staticaccountDao = " + staticaccountDao);
        }
    }
}
