package main.java.wufan.springAOP1.service.impl;


import main.java.wufan.springAOP1.Dao.AccountDao;
import main.java.wufan.springAOP1.Dao.Impl.AccountDaoImpl;
import main.java.wufan.springAOP1.service.IAccountService;

public class AccountserviceImpl implements IAccountService {
    private int i2 = 0;
    private AccountDao accountDao = new AccountDaoImpl();

    public AccountserviceImpl() {
        System.out.println(" 对象被创建了 ");
    }

    public void addAccount() {

        accountDao.addAccount();
        i2++;
        System.out.println("i2 = " + i2);
    }
}
