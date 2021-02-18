package main.java.wufan.ThreadLocal;

import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ee {
    static final  List<Object> list = new LinkedList<>();
    static final  ReferenceQueue queue = new ReferenceQueue();

    public static void main(String[] args) throws IOException, InterruptedException {

        Ebook ebook = new Ebook();
        ebook.setId(1);
        ebook.setPrice(12);
        ebook.setTitle("阿迪");
        List a = new ArrayList();
       // a.add(ebook);
        System.out.println("ebook = " + ebook);
        System.out.println("a = " + a);
        ebook.setTitle("德尔都");
        System.out.println("----------------");
        System.out.println("ebook = " + ebook);
        System.out.println("a = " + a);

        ebook = new Ebook();

        //强引用 通过new出来的对象的引用 （内存溢出也不会被回收）
        byte[] b1 = new byte[1024*1024*6];
        System.out.println("b1 = " + b1);
        byte[] b2 = new byte[1024*1024*6];
        System.out.println("b2 = " + b2);

        //软引用 当内存不够用则 被回收
        SoftReference m = new SoftReference(new byte[1024*1024*6]);
        System.out.println("m.get() = " + m.get());
        SoftReference m1 = new SoftReference(new byte[1024*1024*6]);
        System.out.println("m1.get() = " + m1.get());
        System.out.println("m.get() = " + m.get());

        //弱引用 就算内存够用 当GC执行 就会被回收
        WeakReference w = new WeakReference(new byte[1024*1024*6]);
        System.out.println("w.get() = " + w.get());
        System.gc();
        System.out.println("w.get() = " + w.get());

        //虚引用 是获取不到的 当使用到操作系统内存资源被回收时  通知JVM  来处理对应引用

        PhantomReference p = new PhantomReference(new Ebook() , queue);

        new Thread(()->{
            while (true){
                System.out.println("p.get() = " + p.get());
                list.add(new byte[1024*1024]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                Reference<? extends Ebook> poll = queue.poll();
                if (poll != null) {
                    System.out.println("--虚拟引用对象被回收了-- = " + poll);
                }
            }
        }).start();

        Thread.sleep(500);
    }
}
