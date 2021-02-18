package main.java.wufan.ThreadLocal;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TTest{
    String name;

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.getName() + " 被回收了");
    }



    public static void main(String[] args) {

        new Thread(()->{
            Thread t =Thread.currentThread();
            t.setName("线程1");

            TTest tTest = new TTest();
            System.out.println("装150M");
            List ls = new ArrayList();
            for (int i = 0; i < 24; i++) {
                ThreadLocal l = new ThreadLocal();
                cade cade = new cade("cade"+i,new byte[1024*1024*10]);
                l.set(cade);
                ls.add(l);
               // l=null;
            }

            System.out.println("第一次清理前。。。 " );
            tTest.getXtncSyqk(t.getName());
            System.gc();
            System.out.println("第一次清理后。。。 " );
            tTest.getXtncSyqk(t.getName());

            System.out.println("第二次set。。。 " );
            for (int i = 0; i < 15; i++) {
                ThreadLocal l = new ThreadLocal();
                l.set("");
            }
            tTest.getXtncSyqk(t.getName());
            System.out.println("第2次清理前。。。 " );
            System.gc();
            System.out.println("第2次清理后。。。 " );
            tTest.getXtncSyqk(t.getName());
        }).start();

        if (1 == 1) {
            return;
        }

       // ebook = null;
        System.gc();

        try {
            System.in.read();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
       // System.out.println("e = " + e);


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取系统内存使用情况
     *
     * @return 包含最大内存, 使用内存, 剩余内存的map对象
     */

    public void getXtncSyqk(String name) {
        if (name == null) {
            name = "主线程";
        }

        long maxMem = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        long freeMem = Runtime.getRuntime().freeMemory() / 1024 / 1024;
        long usedMem = maxMem - freeMem;
        System.out.println(name+" MaxMemory = " + maxMem + "MB");
        System.out.println(name+" UsedMemory = " + usedMem + "MB");
        System.out.println(name+" FreeMemory = " + freeMem + "MB");

    }


}

class cade{
   public String name ;
   public byte[] b;

    public cade(String name, byte[] b) {
        this.name = name;
        this.b = b;
    }
}