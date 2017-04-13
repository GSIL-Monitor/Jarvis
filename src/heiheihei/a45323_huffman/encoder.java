package heiheihei.a45323_huffman;

/**
 * @Description encode的入口
 * @Author
 * @Date 2017/4/5
 */
public class encoder {

	public static void main(String[] args) {
		HuffmanAlgorithmImpl huff = new HuffmanAlgorithmImpl();
		huff.encode(args[0]);
	}

}
