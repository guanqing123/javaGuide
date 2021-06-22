package liaoxuefeng.thread;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2021/6/22 8:50
 **/
public class InterruptThread {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1000);
        t.interrupt();  // 中断t线程
        t.join();   //等待t线程结束
        System.out.println("end");
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            Thread hello = new HelloThread();
            hello.start();  // 启动hello线程
            try {
                hello.join();   // 等待hello线程结束
            } catch (InterruptedException e) {
                System.out.println("interrupted!");
            }
            hello.interrupt();
        }
    }

    static class HelloThread extends Thread {
        @Override
        public void run() {
            int n = 0;
            while (!isInterrupted()){
                n++;
                System.out.println(n + "hello!");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

}
