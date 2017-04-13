package heiheihei.a45323_huffman;

import java.io.*;
import java.util.*;

/**
 * @Description huffman encode、decode的实现
 * @Author
 * @Date 2017/4/4
 */
public abstract class HuffmanAlgorithmAbst implements HuffmanAlgorithm {

	@Override
	public void encode(String filePath) {
		File file = new File(filePath);
		Set<HuffmanNode> nodes = new HashSet<>();
		try {
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
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				nodes.add(new HuffmanNode(new Data(entry.getKey(), entry.getValue()), null, null));
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		HuffmanNode rootNode = createTree(nodes, new MyBinaryHeap<>());
		Map<String, String> codeTable = getCodeTable(rootNode);
		try {
			FileWriter tableWriter = new FileWriter("code_table.txt");
			for (Map.Entry<String, String> entry : codeTable.entrySet()) {
				tableWriter.write(entry.getKey() + " " + entry.getValue() + "\n");
			}
			tableWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
//			FileWriter encodeWriter = new FileWriter("encoded.bin");
			FileWriter encodeWriter = new FileWriter("encoded.txt");
			String s;
			while ((s = reader.readLine()) != null && s.length() > 0) {
				encodeWriter.write(codeTable.get(s));
			}
			reader.close();
			encodeWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}


	@Override
	public void decode(String encodedPath, String tablePath) {
		Map<String, String> codeTable = new HashMap<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(tablePath));
			String s;
			while ((s = reader.readLine()) != null && s.length() > 0) {
				String[] wandc = s.split(" ");
				codeTable.put(wandc[0], wandc[1]);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		System.out.println();
		Map<String, String> decodeTable = getDecoder(codeTable);
		try {
			Reader reader = new InputStreamReader(new FileInputStream(new File(encodedPath)));
			FileWriter writer = new FileWriter("decoded.txt");
			int tempChar;
			StringBuffer word = new StringBuffer();
			while ((tempChar = reader.read()) != -1) {
				char c = (char) tempChar;
				word.append((char) tempChar);
				if (decodeTable.containsKey(word.toString())) {
					writer.write(decodeTable.get(word.toString())+"\n");
					word = new StringBuffer();
				}
			}
			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

//	private EncodeResult encode(Map<String, String> codeTable, String words) {
//		StringBuilder encode = new StringBuilder();
//		for (int i = 0, length = words.length(); i < length; i++) {
//
//		}
//	}

	public abstract HuffmanNode createTree(Collection<HuffmanNode> nodes, MyHeap<HuffmanNode> heap);

	/**
	 * 获取所有编码
	 *
	 * @param rootNode 哈夫曼树根结点
	 * @return 所有编码
	 */
	private Map<String, String> getCodeTable(HuffmanNode rootNode) {
		Map<String, String> codeTable = new HashMap<String, String>();
		if (rootNode.getLeftChild() == null && rootNode.getRightChild() == null) {
			codeTable.put(rootNode.getData().getWord(), "1");
		}
		getCodeTable(rootNode, "", codeTable);
		return codeTable;
	}

	/**
	 * 遍历哈夫曼树，获取所有根结点的编码
	 *
	 * @param rootNode  哈夫曼树根结点
	 * @param suffix    编码前缀
	 * @param codeTable 编码表
	 */
	private void getCodeTable(HuffmanNode rootNode, String suffix, Map<String, String> codeTable) {
		if (rootNode == null) {
			return;
		}
		if (rootNode.getLeftChild() == null && rootNode.getRightChild() == null) {
			String word = rootNode.getData().getWord();
			codeTable.put(word, suffix);
		}
		getCodeTable(rootNode.getLeftChild(), suffix + "0", codeTable);
		getCodeTable(rootNode.getRightChild(), suffix + "1", codeTable);
	}

	private Map<String, String> getDecoder(Map<String, String> codeTable) {
		Map<String, String> decodeMap = new HashMap<String, String>();
		for (Map.Entry<String, String> entry : codeTable.entrySet()) {
			decodeMap.put(entry.getValue(), entry.getKey());
		}
		return decodeMap;
	}
}
