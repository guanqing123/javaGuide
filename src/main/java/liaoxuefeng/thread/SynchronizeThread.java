package liaoxuefeng.thread;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2021/6/23 8:48
 **/
public class SynchronizeThread {

    public static void main(String[] args) throws InterruptedException {
        t();
    }

    static class Counter {
        public static final Object lock = new Object();
        public static int count = 0;
    }

    static class AddThread extends Thread {
        @Override
        public void run() {
            for (int i=0; i<10000; i++){
                synchronized (Counter.lock) {
                    Counter.count += 1;
                }
            }
        }
    }

    static class DecThread extends Thread {
        @Override
        public void run() {
            for (int i=0; i<10000; i++){
                synchronized (Counter.lock) {
                    Counter.count -= 1;
                }
            }
        }
    }

    public static void t() throws InterruptedException {
        AddThread add = new AddThread();
        DecThread dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
    }

}
