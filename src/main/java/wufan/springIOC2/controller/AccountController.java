package main.java.wufan.springIOC2.controller;

import main.java.wufan.springIOC2.Dao.AccountDao;
import main.java.wufan.springIOC2.service.IAccountService;
import main.java.wufan.springIOC2.service.impl.AccountserviceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class AccountController {
    private static IAccountService accountService = new AccountserviceImpl();

    /**
     * 获取spring 核心容器对象 并根据ID获取bean
     * @param args
     */
    public static void main(String[] args) throws IOException {

        String path = AccountController.class.getClassLoader().getResource("SpringIOC2beans.xml").getPath();
        path = path.substring(1);
        System.out.println("path = " + path);

        //获取spring 核心容器对象
       // ApplicationContext ac = new FileSystemXmlApplicationContext(path);
        ApplicationContext ac1 = new ClassPathXmlApplicationContext("SpringIOC2beans.xml");

        //根据ID获取bean
        IAccountService iAccountService ;
        AccountDao accountDao ;
        for (int i = 0; i < 5; i++) {
            iAccountService = (IAccountService) ac1.getBean("accountService");
            accountDao= (AccountDao) ac1.getBean("accountDao");

            System.out.println("IAccountService ======== "  + i +"===="+ iAccountService);
            System.out.println("accountDao ========= "  + i +"===="+ accountDao);
        }



    }
}
