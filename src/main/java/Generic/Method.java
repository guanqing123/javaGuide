package Generic;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2021/4/14 13:23
 **/
public class Method {

    public static <E> void printArray(E[] inputArray) {
        for (E element: inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        printArray(intArray);
        printArray(stringArray);
    }

}
