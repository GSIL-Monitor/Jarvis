package test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by test.Poker on 2016/11/20.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Node node = new Node(null);
        node = null;
        System.out.println(null instanceof Node);

        int a = 1500;
        float b = a >> 10;
        System.out.println(a>>10);
        System.out.println((float)(a/1024.0));

//        List list = Arrays.asList("asdf");
//        System.out.println(list);
//        Object o = Arrays.asList("asdf");
//        bad(o);
    }

    public static void bad(Object o) {
        System.out.println("object");
        System.out.println(o instanceof List);
        bad(Collections.singletonList(o));
    }

    public static void bad(List<Object> list) {
        System.out.println("list");
        System.out.println(list);
    }

    private static class Node implements Comparable {
        private String val;
        private Integer count;

        public Node(Map.Entry entry) {
            if (entry == null) {
                return;
            }
            this.val = (String) entry.getKey();
            this.count = (Integer) entry.getValue();
        }

        @Override
        public int compareTo(Object o) {
            if (!(o instanceof Node)) {
                return -1;
            }
            return this.count.compareTo(((Node) o).count);
        }

        @Override
        public String toString() {
            return String.format("val: %s, count: %s\n", val, count);
        }
    }

}