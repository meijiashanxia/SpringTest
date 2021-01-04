package wufan.springIOC1.service.impl;


import wufan.springIOC1.Dao.AccountDao;
import wufan.springIOC1.Dao.Impl.AccountDaoImpl;
import wufan.springIOC1.service.IAccountService;

public class AccountserviceImpl implements IAccountService {
    private int i= 0;
    private AccountDao accountDao = new AccountDaoImpl();
    public void addAccount() {

        accountDao.addAccount();
        i++;
        System.out.println("i = " + i);
    }
}
