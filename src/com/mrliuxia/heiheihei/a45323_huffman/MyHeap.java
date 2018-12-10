package com.mrliuxia.heiheihei.a45323_huffman;

/**
 * @Description 堆接口的抽象定义
 * @Author
 * @Date 2017/4/4
 */
public interface MyHeap<T> {

	void add(T t);

	T getMin();

	T popMin();

	boolean isEmpty();

}
