package Generic;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2021/4/14 13:14
 **/
public class GeneratorImpl2<T> implements Generator<String>{
    @Override
    public String method() {
        return "abc";
    }

    public static void main(String[] args) {
        Generator g = new GeneratorImpl2<Integer>();
        System.out.println(g.method());
    }
}
