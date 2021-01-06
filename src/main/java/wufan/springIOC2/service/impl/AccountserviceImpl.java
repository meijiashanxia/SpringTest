package main.java.wufan.springIOC2.service.impl;


import main.java.wufan.springIOC2.Dao.AccountDao;
import main.java.wufan.springIOC2.Dao.Impl.AccountDaoImpl;
import main.java.wufan.springIOC2.service.IAccountService;

public class AccountserviceImpl implements IAccountService {
    private int i2= 0;
    private AccountDao accountDao = new AccountDaoImpl();
    public void addAccount() {

        accountDao.addAccount();
        i2++;
        System.out.println("i2 = " + i2);
    }
}
