package liaoxuefeng.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2021/6/17 9:07
 **/
public class MapTest {

    public static void main(String[] args) {

        long s1 = System.currentTimeMillis();
        Map<String, Integer> map1 = new HashMap<>();
        for (int i=0; i<1000; i++){
            map1.put(String.valueOf(i), i);
        }
        long e1 = System.currentTimeMillis();
        System.out.println("process 1 消耗 " + (e1 - s1) + " ms");


        long s2 = System.currentTimeMillis();
        Map<String, Integer> map2 = new HashMap<>(1000);
        for (int i=0; i<1000; i++){
            map1.put(String.valueOf(i), i);
        }
        long e2 = System.currentTimeMillis();
        System.out.println("process 2 消耗 " + (e2 - s2) + " ms");
    }

}
