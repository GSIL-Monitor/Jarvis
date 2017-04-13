package heiheihei.a45323_huffman;

/**
 * @Description binary heap
 * @Author
 * @Date 2017/4/4
 */
public class MyBinaryHeap<T extends Comparable> implements MyHeap<T> {

	private static final int DEFAULT_CAPACITY = 10;// 默认容量  
	private int currentSize; // 当前堆大小  
	private T[] array; // 数组  

	public MyBinaryHeap() {
		this(DEFAULT_CAPACITY);
	}

	public MyBinaryHeap(int capacity) {
		currentSize = 0;
		array = (T[]) new Comparable[capacity + 1];
	}

	public MyBinaryHeap(T[] items) {
		currentSize = items.length;
		array = (T[]) new Comparable[(currentSize + 2) * 11 / 10];
		int i = 1;
		for (T item : items) {
			array[i++] = item;
		}
		buildHeap();
	}

	@Override
	public void add(T t) {
		if (isFull()) {
			enlargeArray(array.length * 2 + 1);
		}
		int hole = ++currentSize;
		for (; hole > 1 && t.compareTo(array[hole / 2]) < 0; hole /= 2) {
			array[hole] = array[hole / 2];
		}
		array[hole] = t;
	}

	@Override
	public T getMin() {
		if (isEmpty())
			return null;
		return array[1];
	}

	@Override
	public T popMin() {
		if (isEmpty()) {
			throw new RuntimeException();
		}
		T minItem = getMin();
		array[1] = array[currentSize];
		array[currentSize--] = null;
		percolateDown(1);
		return minItem;
	}

	@Override
	public boolean isEmpty() {
		return currentSize == 0;
	}

	private void buildHeap() {
		for (int i = currentSize / 2; i > 0; i--) {
			percolateDown(i);
		}
	}

	private void percolateDown(int hole) {
		int child;
		T tmp = array[hole];
		for (; hole * 2 <= currentSize; hole = child) {
			child = hole * 2;
			if (child != currentSize && array[child + 1].compareTo(array[child]) < 0) {
				child++;
			}
			if (array[child].compareTo(tmp) < 0) {
				array[hole] = array[child];
			} else {
				break;
			}
		}
		array[hole] = tmp;
	}

	public boolean isFull() {
		return currentSize == array.length - 1;
	}

	@SuppressWarnings("unused")
	public void clear() {
		currentSize = 0;
		for (T T : array) {
			T = null;
		}
	}

	public int size() {
		return currentSize;
	}

	private void enlargeArray(int newSize) {
		T[] old = array;
		array = (T[]) new Comparable[newSize];
		for (int i = 0; i < old.length; i++) {
			array[i] = old[i];
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (T t : array) {
			if (t != null) {
				sb.append(t + " ");
			}
		}
		return sb.toString();
	}

}
