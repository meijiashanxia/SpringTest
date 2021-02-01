package main.java.wufan.springIOC2.controller;

import main.java.wufan.springIOC2.Dao.AccountDao;
import main.java.wufan.springIOC2.service.IAccountService;
import main.java.wufan.springIOC2.service.impl.AccountserviceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class AccountController {

    /**
     * 获取spring 核心容器对象 并根据ID获取bean
     * @param args
     */
    public static void main(String[] args) throws IOException {

        String path = AccountController.class.getClassLoader().getResource("SpringIOC2beans.xml").getPath();
        path = path.substring(1);
        System.out.println("path = " + path);

      /*  //获取spring 核心容器对象 spring提供了两个接口（ApplicationContext ） 来创建容器对象
        ApplicationContext ac1 = new FileSystemXmlApplicationContext
                ("D:/allSoftWare/code/development/SpringTest/target/classes/SpringIOC2beans.xml");

        ApplicationContext ac2 = new ClassPathXmlApplicationContext("SpringIOC2beans.xml");
*/
       // ApplicationContext ac3 = new AnnotationConfigApplicationContext();

        Resource resource = new ClassPathResource("SpringIOC2beans.xml");
        BeanFactory ac4 = new XmlBeanFactory(resource);


        //根据ID获取bean
        IAccountService iAccountService;
        AccountDao accountDao;

        /*iAccountService = (IAccountService) ac1.getBean("accountService");
        accountDao= (AccountDao) ac1.getBean("accountDao");*/
        for (int i = 0; i < 5; i++) {
            iAccountService = (IAccountService) ac4.getBean("accountService");
            System.out.println("BeanFactory      iAccountService = " + iAccountService);
        }


      /*  for (int i = 0; i < 5; i++) {
            iAccountService = (IAccountService) ac1.getBean("accountService");
            accountDao= (AccountDao) ac1.getBean("accountDao");

            System.out.println("IAccountService ======== "  + i +"===="+ iAccountService);
            System.out.println("accountDao ========= "  + i +"===="+ accountDao);
        }

        for (int i = 0; i < 5; i++) {
            iAccountService = (IAccountService) ac2.getBean("accountService");
            accountDao= (AccountDao) ac2.getBean("accountDao");

            System.out.println("IAccountService2 ======== "  + i +"===="+ iAccountService);
            System.out.println("accountDao2 ========= "  + i +"===="+ accountDao);
        }*/

    }
}
