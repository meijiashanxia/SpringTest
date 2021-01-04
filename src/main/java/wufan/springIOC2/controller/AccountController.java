package wufan.springIOC2.controller;

import wufan.springIOC2.service.IAccountService;
import wufan.springIOC2.service.impl.AccountserviceImpl;

public class AccountController {
    private static IAccountService accountService = new AccountserviceImpl();
    public static void main(String[] args) {

        accountService.addAccount();

    }
}
