package com.mrliuxia.heiheihei.a45323_huffman;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 4-way cache optimized heap
 * @Author liuxiao
 * @Date 2017/4/5
 */
public class MyFourWayHeap<T extends Comparable> implements MyHeap<T> {

	private List<T> heap;

	public MyFourWayHeap() {
		heap = new ArrayList();
		heap.add(null);
		heap.add(null);
		heap.add(null);
	}

	@Override
	public void add(T t) {
		heap.add(t);
		Integer currIndex = heap.size() - 1;
		if (heap.size() == 4)
			return;
		T parent = heap.get(getParentIndex(currIndex));
		while (t.compareTo(parent) < 0 && getParentIndex(currIndex) >= 3) {
			swapNodes(getParentIndex(currIndex), currIndex);
			currIndex = getParentIndex(currIndex);
			parent = heap.get(getParentIndex(currIndex));
		}
	}

	@Override
	public T popMin() {
		if (heap.size() < 4) {
			return null;
		}
		T min = heap.get(3);
		if (heap.size() - 1 == 3) {
			heap.remove(3);
			return min;
		}
		heap.set(3, heap.remove(heap.size() - 1));
		minHeapify(3);
		return min;
	}

	@Override
	public T getMin() {
		if (heap.size() < 4) {
			return null;
		}
		return heap.get(3);
	}

	@Override
	public boolean isEmpty() {
		return heap == null || heap.size() < 4;
	}

	public int getParentIndex(int n) {
		if (n == 3) {
			return 3;
		}
		return (n) / 4 + 2;
	}

	public int getChildOneIndex(int n) {
		return 4 * n + 1 - 9 < heap.size() - 1 ? 4 * n + 1 - 9 : -1;
	}

	public int getChildTwoIndex(int n) {
		return 4 * n + 2 - 9 < heap.size() - 1 ? 4 * n + 2 - 9 : -1;
	}

	public int getChildThreeIndex(int n) {
		return 4 * n + 3 - 9 < heap.size() - 1 ? 4 * n + 3 - 9 : -1;
	}

	public int getChildFourIndex(int n) {
		return 4 * n + 4 - 9 < heap.size() - 1 ? 4 * n + 4 - 9 : -1;
	}

	public void minHeapify(Integer numberIndex) {
		int minChildIdx = minOfChildren(numberIndex);
		if (minChildIdx == -1) {
			return;
		}
		swapNodes(minChildIdx, numberIndex);
		minHeapify(minChildIdx);
	}


	public void swapNodes(Integer node1Idx, Integer node2Idx) {
		T temp = heap.get(node1Idx);
		heap.set(node1Idx, heap.get(node2Idx));
		heap.set(node2Idx, temp);
	}

	private int minOfChildren(int numberIdx) {
		int c1 = getChildOneIndex(numberIdx);
		int c2 = getChildTwoIndex(numberIdx);
		int c3 = getChildThreeIndex(numberIdx);
		int c4 = getChildFourIndex(numberIdx);
		int minChildOf12;
		int minChildOf34;
		int minChild;

		if (c1 != -1 && c2 != -1) {
			minChildOf12 = heap.get(c1).compareTo(heap.get(c2)) < 0 ? c1 : c2;
		} else if (c1 == -1 && c2 == -1) {
			minChildOf12 = -1;
		} else if (c1 == -1) {
			minChildOf12 = c2;
		} else {
			minChildOf12 = c1;
		}

		if (c3 != -1 && c4 != -1) {
			minChildOf34 = heap.get(c3).compareTo(heap.get(c4)) < 0 ? c3 : c4;
		} else if (c3 == -1 && c4 == -1) {
			minChildOf34 = -1;
		} else if (c3 == -1) {
			minChildOf34 = c4;
		} else {
			minChildOf34 = c3;
		}

		if (minChildOf12 != -1 && minChildOf34 != -1) {
			minChild = heap.get(minChildOf12).compareTo(heap.get(minChildOf34)) < 0 ? minChildOf12 : minChildOf34;
		} else if (minChildOf12 == -1 && minChildOf34 == -1) {
			minChild = -1;
		} else if (minChildOf12 == -1) {
			minChild = minChildOf34;
		} else {
			minChild = minChildOf12;
		}
		return minChild;
	}

}