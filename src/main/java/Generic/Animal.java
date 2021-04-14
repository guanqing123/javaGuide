package Generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2021/4/14 13:37
 **/
public class Animal {

    private int legs;

    public int getLegs() {
        return legs;
    }

    public void print(){
        System.out.printf("i have %d 条腿", legs);
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public int countLeg(){
        return legs;
    }

    static int countLegs (List<? extends Animal> animals) {
        int retVal = 0;
        for (Animal animal: animals) {
            retVal += animal.countLeg();
        }
        return retVal;
    }

    static int countLeg(List<Animal> animals){
        int retVal = 0;
        for (Animal animal: animals) {
            retVal += animal.countLeg();
        }
        return retVal;
    }

    /* 上界通配符 */
    private <K extends Dog, E extends Animal> E test(K arg1, E arg2) {
        E result = arg2;
        arg2.equals(arg1);

        return result;
    }

    class Dog extends Animal{}

    /* 下界通配符 */
    private static  <T> void test(List<? super T> dst, List<T> src) {
        for (T t: src) {
            dst.add(t);
        }
    }

    private static <T extends Number> void sure(List<T> dest, List<T> src) {}

    private static void nosure(List<? extends Number> desc, List<? extends Number> src){}


    private static <T extends Number & Cloneable> void extendsT(T t){}

//    private static <T super Number> void superT(){}

    public class Test3<T>{
        public Class<?> clazz;

        public Class<T> clazzT;
    }

    public static void main(String[] args) {

        List<Dog> dogs = new ArrayList<>();

        // 编译通过
        countLegs(dogs);

        // 报错
        // countLeg(dogs);

        List<Animal> dst = new ArrayList<>();
        List<Dog> src = new ArrayList<>();
        test(dst, src);

        List<Integer> dest = new ArrayList<>();
        List<Integer> ssrc = new ArrayList<>();
        sure(dest, ssrc);

        List<Integer> ndesc = new ArrayList<>();
        List<Short> nsrc = new ArrayList<>();
        nosure(ndesc, nsrc);

        try {
            Animal animal = (Animal) Class.forName("Generic.Animal").newInstance();
            animal.setLegs(5);
            animal.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
