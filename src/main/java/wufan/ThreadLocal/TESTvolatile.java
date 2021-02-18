package main.java.wufan.ThreadLocal;

public class TESTvolatile {

//        public volatile int inc = 0;
        public int inc = 0;

        public  void increase() {
            synchronized (this) {
                System.out.println("this = " + this.getClass().getName());
                inc++;
            }
        }

        public static void main(String[] args) throws InterruptedException {
            final TESTvolatile test = new TESTvolatile();
            for(int i=0;i<10;i++){
                new Thread(){
                    public void run() {
                        for(int j=0;j<1000;j++) {
                            test.increase();

                        }

                    };
                }.start();
            }

            while(Thread.activeCount()>2)  //保证前面的线程都执行完
                Thread.yield();
            System.out.println(test.inc);

        }
}
