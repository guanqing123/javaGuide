package liaoxuefeng.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2021/6/18 16:41
 **/
public class ArrayListTest {

    public static void main(String[] args) throws InterruptedException {
//        arrayListTest();
        vectorTest();
    }

    public static void vectorTest() throws InterruptedException {

        long start = System.currentTimeMillis();

        final Vector<Integer> vector = new Vector<>();

        // 线程A将 0-1000 添加到list
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    vector.add(i);

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // 线程B将 1000-2000添加到列表
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1000; i<2000; i++){
                    vector.add(i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.sleep(5000);

        //打印所有结果
        for (int i = 0; i < vector.size(); i++){
            System.out.println("第" + (i + 1) + "个元素为："+ vector.get(i));
        }

        long end = System.currentTimeMillis();

        System.out.println("总计："+ (end - start) +"ms");

    }

    public static void arrayListTest() throws InterruptedException {

        long start = System.currentTimeMillis();

//        final List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());

        final List<Integer> list = new ArrayList<>();

        // 线程A将 0-1000 添加到list
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    list.add(i);

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // 线程B将 1000-2000添加到列表
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1000; i<2000; i++){
                    list.add(i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.sleep(5000);

        //打印所有结果
        for (int i = 0; i < list.size(); i++){
            System.out.println("第" + (i + 1) + "个元素为："+ list.get(i));
        }

        long end = System.currentTimeMillis();

        System.out.println("总计："+ (end - start) +"ms");
    }

}
