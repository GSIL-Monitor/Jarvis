package heiheihei.a45323_huffman;

/**
 * @Description huffman tree的节点
 * @Author
 * @Date 2017/4/4
 */
public class HuffmanNode implements Comparable<HuffmanNode> {

	private Data data;
	private HuffmanNode leftChild;
	private HuffmanNode rightChild;

	public HuffmanNode(Data data, HuffmanNode leftChild, HuffmanNode rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return "Node [leftChild=" + leftChild + ", data=" + data + ", rightChild=" + rightChild + "]";
	}

	@Override
	public int compareTo(HuffmanNode o) {
		return this.data.compareTo(o.getData());
	}

	public Data getData() {
		return data;
	}

	@Override
	public int hashCode() {
		return data.getWord().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof HuffmanNode)) {
			return false;
		}
		return ((HuffmanNode) obj).data.getWord().equals(((HuffmanNode) obj).getData().getWord());
	}

	public void setData(Data data) {
		this.data = data;
	}

	public HuffmanNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(HuffmanNode leftChild) {
		this.leftChild = leftChild;
	}

	public HuffmanNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(HuffmanNode rightChild) {
		this.rightChild = rightChild;
	}
}
