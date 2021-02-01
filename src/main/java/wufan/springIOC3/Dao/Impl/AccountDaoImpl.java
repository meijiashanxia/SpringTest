package main.java.wufan.springIOC3.Dao.Impl;


import main.java.wufan.springIOC3.Dao.AccountDao;

public class AccountDaoImpl implements AccountDao {

    public void init(){
        System.out.println("AccountDaoImpl出生了！");
    }
    public void destory(){
        System.out.println("AccountDaoImpl洗白了！");
    }
    public void addAccount() {
        System.out.println("帐号添加成功！");
    }
}
