package main.java.wufan.ThreadLocal;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class T1 {
    private static final int HASH_INCREMENT = 0x61c88647;
    String str = null;

    public static void main(String[] args) {


        new Thread(()->{
            ThreadLocal th = new ThreadLocal();
            Ebook ebook = new Ebook();
            ebook.setTitle("爱豆机位熊大");
            Ebook ebook1 = new Ebook();
            ebook1.setTitle("ebook1");
            th.set(ebook);

            th = null;
            ebook = null;
            ebook1 = null;
            System.gc();

            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }).start();

        if (true) return;
        for (int i = 0; i < 32; i++) {
           int nextHashCode = i * HASH_INCREMENT + HASH_INCREMENT;
            System.out.println(nextHashCode & (32 - 1));
        }



        if (true) return;

        Ebook ebook = new Ebook();
        ebook.setId(1);
        ebook.setPrice(12);
        ebook.setTitle("阿迪");

        ThreadLocal threadLocal1 = new ThreadLocal();

        //线程1存值
        new Thread(()->{
            threadLocal1.set(ebook);
        }).start();

        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadLocal1.get();
            System.out.println("threadLocal1.get() = " + threadLocal1.get());
        }).start();

    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
