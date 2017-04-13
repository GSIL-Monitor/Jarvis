package ztest;

import heiheihei.a45323_huffman.MyBinaryHeap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ztest.Poker on 2016/11/20.
 */
public class Test{
    public static void main(String[] args) throws Exception{
        File file = new File("/Users/Poker/Desktop/sample_input_small.txt");
//        File file = new File("/Users/Poker/Downloads/45323/sample2large/sample_input_large.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String s;
        Map<String, Integer> map = new HashMap<>();
        MyBinaryHeap<Node> heap = new MyBinaryHeap<>();
        long startTime = System.currentTimeMillis();
        while ((s = reader.readLine()) != null && s.length()>0) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            }else {
                map.put(s, 1);
            }
        }
        long spentTime = System.currentTimeMillis() - startTime;
        for (Map.Entry entry : map.entrySet()) {
            heap.add(new Node(entry));
        }
        reader.close();
        while (heap.size() > 0) {
            System.out.println(heap.popMin());
        }


    }

    private static class Node implements Comparable{
        private String val;
        private Integer count;

        public Node(Map.Entry entry) {
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