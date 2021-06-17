package liaoxuefeng.collection;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2021/6/17 13:03
 **/
public class TreeMapTest {

    public static void main(String[] args) {

        /*Map<Student, Integer> map = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.score == o2.score) return 0;
                return o1.score - o2.score > 0 ? 1 : -1;
            }
        });*/
        Map<Student, Integer> map = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (Objects.equals(o1.name, o2.name) && o1.score == o2.score) {
                    return 0;
                } else if (!Objects.equals(o1.name, o2.name) && o1.score == o2.score) {
                    return -1;
                }
                return o1.score - o2.score;
            }
        });
        map.put(new Student("zhangsan", 20), 1);
        map.put(new Student("lisi", 15), 2);
        map.put(new Student("wangwu", 13), 3);

        for (Student stu :
             map.keySet()) {
            System.out.println(stu.name);
        }

        System.out.println(map.get(new Student("zhangsan", 20)));
        System.out.println(map.get(new Student("zs", 20)));
    }

    static class Student {
        public String name;
        public int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

}
