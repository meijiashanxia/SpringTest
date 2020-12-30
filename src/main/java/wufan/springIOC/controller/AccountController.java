package wufan.springIOC.controller;

import li.factory.JavaBeanFactory;
import wufan.springIOC.service.IAccountService;

public class AccountController {
    //private static IAccountService accountService = (IAccountService) JavaBeanFactory.getBean("accountService");
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            IAccountService accountService = (IAccountService) JavaBeanFactory.getBean("accountService");
            IAccountService accountService2 = (IAccountService) JavaBeanFactory.getBean("accountService");
            System.out.println("accountService = " + accountService);
            System.out.println("accountService = " + accountService2);
               accountService.addAccount();
        }





    }
}
