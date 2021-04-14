package Generic;

public class GeneratorImpl<T> implements Generator<T>{

    @Override
    public T method() {
        return null;
    }

    public static void main(String[] args) {
        Generator g = new GeneratorImpl();
        g.method();
    }
}
