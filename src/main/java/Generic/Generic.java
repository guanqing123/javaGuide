package Generic;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2021/4/14 12:56
 **/
public class Generic<T> {

    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public static void main(String[] args) {
        Generic g = new Generic<Double>(123.0);
        System.out.println(g.getKey());
    }
}
