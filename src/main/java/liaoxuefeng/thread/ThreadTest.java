package liaoxuefeng.thread;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2021/6/22 15:23
 **/
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        t.join();
        System.out.println("main end");
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            HelloThread hello = new HelloThread();
            hello.start();

            try {
                hello.join();
            } catch (InterruptedException e) {
                System.out.println("interrupt");
            }

            hello.interrupt();
        }
    }

    static class HelloThread extends Thread {
        @Override
        public void run() {
            int n = 0;
            while (!isInterrupted()) {
                System.out.println(n +"\t"+"run...");
                n++;
            }
            System.out.println("hello end");
        }
    }
}
