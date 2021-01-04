package wufan.springIOC1.controller;


import wufan.springIOC1.Dao.AccountDao;
import wufan.springIOC1.Dao.Impl.AccountDaoImpl;
import wufan.springIOC1.factory.JavaBeanFactory;
import wufan.springIOC1.service.IAccountService;

public class AccountController {
    //private static IAccountService accountService = (IAccountService) JavaBeanFactory.getBean("accountService");
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            IAccountService accountService = (IAccountService) JavaBeanFactory.getBean("accountService");
            IAccountService accountService2 = (IAccountService) JavaBeanFactory.getBean("accountService");
            System.out.println("accountService = " + accountService);
            System.out.println("accountService = " + accountService2);
               accountService.addAccount();

            AccountDao accountDao = new AccountDaoImpl();
            System.out.println("accountDao = " + accountDao);
        }





    }
}
