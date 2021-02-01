package main.java.wufan.springIOC3.service.impl;


import main.java.wufan.springIOC3.Dao.AccountDao;
import main.java.wufan.springIOC3.Dao.Impl.AccountDaoImpl;
import main.java.wufan.springIOC3.service.IAccountService;

public class AccountserviceImpl implements IAccountService {
    private AccountDao accountDao = new AccountDaoImpl();

    public AccountserviceImpl() {
        System.out.println(" 对象被创建了 ");
    }

    public void addAccount() {

        accountDao.addAccount();
    }
}
