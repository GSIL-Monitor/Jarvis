package com.mrliuxia.heiheihei.a45323_huffman;

/**
 * @Description 定义huffman编码解码抽象接口
 * @Author
 * @Date 2017/4/4
 */
public interface HuffmanAlgorithm {

	/**
	 * 编码
	 */
	void encode(String path);

	/**
	 * 解码
	 */
	void decode(String path, String tablePath);

}
