package com.mrliuxia.heiheihei.a45323_huffman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description 测试堆速度，选择构建对堆的方式
 * @Author
 * @Date 2017/4/4
 */
public class SpeedTest {

	public static void main(String[] args) throws Exception {
//		String path = "sample_input_small.txt";
		String path = "sample_input_large.txt";
		File file = new File(path);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String s;
		Map<String, Integer> map = new HashMap<>();
		while ((s = reader.readLine()) != null && s.length() > 0) {
			if (map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}
		}
		Set<HuffmanNode> nodes = new HashSet<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			nodes.add(new HuffmanNode(new Data(entry.getKey(), entry.getValue()), null, null));
		}

		long time;
		HuffmanAlgorithmImpl huff = new HuffmanAlgorithmImpl();
		huff.createTree(nodes, new MyBinaryHeap<>());

		for (int i = 0; i < 3; i++) {
			System.out.println("Round " + (i + 1) + ": ");

			time = System.currentTimeMillis();
			for (int j = 0; j < 10; j++) {
				huff.createTree(nodes, new MyBinaryHeap<>());
			}
			System.out.println(" build binary heap 10 times: " + (System.currentTimeMillis() - time) + "ms");

			time = System.currentTimeMillis();
			for (int j = 0; j < 10; j++) {
				huff.createTree(nodes, new MyFourWayHeap<>());
			}
			System.out.println(" build four way heap 10 times: " + (System.currentTimeMillis() - time) + "ms");

			time = System.currentTimeMillis();
			for (int j = 0; j < 10; j++) {
				huff.createTree(nodes, new MyPairingHeap<>());
			}
			System.out.println(" build pairing heap 10 times: " + (System.currentTimeMillis() - time) + "ms\n");

		}
	}

}
