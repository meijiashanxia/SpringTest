package main.java.wufan.springIOC3.factory;

import main.java.wufan.springIOC3.Dao.Impl.AccountDaoImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class StaticJavaBeanFactory {
    static AccountDaoImpl getInstance(String string){
        System.out.println("string = static]]]]]]]]" + string);

        return new AccountDaoImpl();
    }

}
