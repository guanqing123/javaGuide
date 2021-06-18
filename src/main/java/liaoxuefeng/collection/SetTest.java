package liaoxuefeng.collection;

import java.util.*;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2021/6/18 8:41
 **/
public class SetTest {

    public static void main(String[] args) {
//        hashSet();
//        hashVsTree();

        practise();
    }

    public static void hashSet(){
        Set<String> set = new HashSet<>();
        System.out.println(set.add("abc")); // true

        System.out.println(set.add("xyz")); // true

        System.out.println(set.add("xyz")); // false

        System.out.println(set.contains("xyz")); // true

        System.out.println(set.contains("XYZ")); // false

        System.out.println(set.size()); // 2
    }

    public static void hashVsTree(){

        Set<String> hset = new HashSet<>();
        hset.add("apple");
        hset.add("banana");
        hset.add("pear");
        hset.add("orange");
        for (String s : hset){
            System.out.println(s);
        }

        System.out.println("\n");

        Set<String> tset = new TreeSet<>();
        tset.add("apple");
        tset.add("banana");
        tset.add("pear");
        tset.add("orange");
        for (String s : tset){
            System.out.println(s);
        }

    }

    public static void practise(){

        List<Message> received = Arrays.asList(
                new Message(1, "Hello!"),
                new Message(2,"发工资了吗?"),
                new Message(2,"发工资了吗?"),
                new Message(3,"去哪吃饭?"),
                new Message(3,"去哪吃饭?"),
                new Message(4,"Bye")
        );

        List<Message> displayMessage = process(received);
        for (Message message: displayMessage) {
            System.out.println(message.text);
        }
    }

    static List<Message> process(List<Message> received){
        // TODO: 按sequence去除重复消息

        Set<Message> set = new TreeSet<>(received);

        return new ArrayList<>(set);
    }

    static List<Message> process2(List<Message> received) {
        // TODO: 按sequence去除重复消息

        Set<Message> set = new HashSet<>(received);

        return new ArrayList<>(set);
    }


    /**
    * @ Author:guanqing
    * @ Date 2021/6/18 10:49
    * @ Description // 自己的思路
    * @ Param[received]
    * @ return java.util.List<liaoxuefeng.collection.SetTest.Message>
    **/
    @Deprecated
    static List<Message> process1(List<Message> received){
        // TODO: 按sequence去除重复消息

        Set<Message> s = new TreeSet<>(received);

        Set<Message> set = new TreeSet<>(new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                return o1.sequence - o2.sequence;
            }
        });

        set.addAll(received);

        List nl = new ArrayList();
        nl.addAll(set);

        return nl;
    }

    static class Message implements Comparable<Object>{
        public final int sequence;
        public final String text;

        public Message(int sequence, String text) {
            this.sequence = sequence;
            this.text = text;
        }

        /**
         * equals & hashCode 重写是为了 HashSet 的要求
         * @Author guanqing
         * @Date 2021/6/18 10:55
         **/
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Message) {
                Message m = (Message) obj;
                return this.sequence == m.sequence && Objects.equals(this.text, m.text);
            }
            return false;
        }

        @Override
        public int hashCode() {
            int n = 0;
            n = 31 * n + this.sequence;
            n = 31 * n + this.text.hashCode();
            return n;
        }

        /**
         * compareTo 为了 TreeSet
         * @Author guanqing
         * @Date 2021/6/18 11:05
         **/
        @Override
        public int compareTo(Object o) {
            Message m = (Message) o;
            if (this.sequence == m.sequence){
                return 0;
            }
            return this.sequence > m.sequence ? 1 : -1;
        }
    }
}
