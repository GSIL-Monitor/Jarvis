package com.mrliuxia.heiheihei.a45323_huffman;

/**
 * @Description huffman树节点的data，词频
 * @Author
 * @Date 2017/4/4
 */
public class Data implements Comparable<Data> {

	private String word;
	private int frequency;

	public Data(String word, int frequency) {
		this.word = word;
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "word: " + word + ", frequency: " + frequency + "\n";
	}

	@Override
	public int compareTo(Data o) {
		if (this.frequency < o.getFrequency()) {
			return -1;
		} else if (this.frequency == o.getFrequency()) {
			return 0;
		}else {
			return 1;
		}
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
}
