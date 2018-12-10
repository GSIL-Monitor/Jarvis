package com.mrliuxia.heiheihei.a45323_huffman;

/**
 * @Description decode的入口
 * @Author
 * @Date 2017/4/5
 */
public class decoder {

	public static void main(String[] args) {
		HuffmanAlgorithmImpl huff = new HuffmanAlgorithmImpl();
		huff.decode(args[0], args[1]);
	}

}
