package wufan.springIOC.service.impl;


import wufan.springIOC.Dao.AccountDao;
import wufan.springIOC.Dao.Impl.AccountDaoImpl;
import wufan.springIOC.service.IAccountService;

public class AccountserviceImpl implements IAccountService {
    private int i= 0;
    private AccountDao accountDao = new AccountDaoImpl();
    public void addAccount() {

        accountDao.addAccount();
        i++;
        System.out.println("i = " + i);
    }
}
