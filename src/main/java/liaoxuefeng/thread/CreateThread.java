package liaoxuefeng.thread;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2021/6/21 9:07
 **/
public class CreateThread {

    public static void main(String[] args) {

        System.out.println("main start...");

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread run...");

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("thread end.");
            }
        });

        t.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end...");

    }

}
