package heiheihei.a45323_huffman;

import java.util.Collection;

/**
 * @Description huffman tree的构造实现
 * @Author
 * @Date 2017/4/4
 */
public class HuffmanAlgorithmImpl extends HuffmanAlgorithmAbst {

	@Override
	public HuffmanNode createTree(Collection<HuffmanNode> nodes, MyHeap<HuffmanNode> heap) {
		for (HuffmanNode node : nodes) {
			heap.add(node);
		}
		for (int i = 1; i < nodes.size(); i++) {
			HuffmanNode left = heap.popMin();
			HuffmanNode right = heap.popMin();
			Data data = new Data("", left.getData().getFrequency() + right.getData().getFrequency());
			HuffmanNode parent = new HuffmanNode(data, left, right);
			heap.add(parent);
		}
		return heap.getMin();
	}

}
