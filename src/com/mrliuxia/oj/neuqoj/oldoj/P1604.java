package com.mrliuxia.oj.neuqoj.oldoj;

/**
 * 问题描述 对于长度为5位的一个01串，每一位都可能是0或1，一共有32种可能。它们的前几个是： 00000 00001 00010 00011 00100 请按从小到大的顺序输出这32种01串。
 * Created by Poker on 2017/3/14.
 */
public class P1604 {

	public static void main(String[] args) {
		for (int i = 0; i < 32; i++) {
			System.out.println(String.format("%05d", Integer.parseInt(Integer.toBinaryString(i))));
		}
	}

}
