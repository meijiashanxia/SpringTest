package main.java.wufan.springIOC3.factory;

import main.java.wufan.springIOC3.Dao.Impl.AccountDaoImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 模拟一个第三方工厂类，该且存在于jar 需要配置beans.xml 从指定的静态方法获取我们需要的对象
 */
public class JavaBeanFactory {


    JavaBeanFactory(){}

    AccountDaoImpl getInstance(String string){
        System.out.println("string = ]]]]]]]]]]]]" + string);

        return new AccountDaoImpl();
    }
}
