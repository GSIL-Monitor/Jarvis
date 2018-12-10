package com.mrliuxia.heiheihei.a45323_huffman;

/**
 * @Description pairing heap
 * @Author
 * @Date 2017/4/4
 */
public class MyPairingHeap<T extends Comparable> implements MyHeap<T> {

	private Node root;

	private Node linkPair(Node first, Node second) {
		if (second == null) return first;
		if (first == null) return second;

		if (first.compareTo(second) < 1) {
			Node secondzSibling = second.sibling;
			first.sibling = secondzSibling;
			if (secondzSibling != null) secondzSibling.left = first;

			Node firstzChild = first.child;
			second.left = first;
			second.sibling = firstzChild;

			if (firstzChild != null) firstzChild.left = second;
			first.child = second;
			return first;
		} else {
			Node firstzLeft = first.left;
			second.left = firstzLeft;
			if (firstzLeft != null) {
				if (firstzLeft.child == first) {
					firstzLeft.child = second;
				} else {
					firstzLeft.sibling = second;
				}
			}

			Node secondzChild = second.child;
			first.left = second;
			first.sibling = secondzChild;

			if (secondzChild != null) secondzChild.left = first;
			second.child = first;
			return second;
		}
	}

	@Override
	public void add(T t) {
		Node node = new Node(t);
		if (root == null)
			root = node;
		else
			root = linkPair(node, root);
	}

	public void merge(Node rhs) {
		if (this.root == null) {
			this.root = rhs;
			return;
		}
		if (rhs == null) return;

		this.root = this.linkPair(this.root, rhs);
	}

	@Override
	public T getMin() {
		return (T) this.root.key;
	}

	@Override
	public T popMin() {
		Node z = this.root;
		if (z != null) {
			if (z.child == null)
				root = null;
			else {
				Node firstSibling = z.child;
				firstSibling.left = null;
				root = mergeSubHeaps(firstSibling);
			}
		}
		return (T) z.key;
	}

	@Override
	public boolean isEmpty() {
		if (this.root == null) {
			return true;
		} else {
			return false;
		}
	}

	private Node mergeSubHeaps(Node firstSibling) {
		//the 1st pass: merge pairs from left side
		Node first = firstSibling;
		Node second = first.sibling;

		Node tail = first;
		if (second != null) {
			tail = this.linkPair(first, second);
			first = tail.sibling;
			if (first != null)
				second = first.sibling;
			else
				second = null;
		}
		while (first != null && second != null) {
			tail = this.linkPair(first, second);
			first = tail.sibling;
			if (first != null)
				second = first.sibling;
			else
				second = null;
		}

		//the 2nd pass: merge pairs from right side
		if (first != null) {
			tail = first;
		}

		Node prev = tail.left;
		while (prev != null) {
			tail = this.linkPair(prev, tail);
			prev = tail.left;
		}
		return tail;
	}


	class Node<T extends Comparable> implements Comparable {
		private T key;
		private Node left;
		private Node sibling;
		private Node child;

		public Node(T key) {
			this.key = key;
		}

		@Override
		public int compareTo(Object o) {
			if (!(o instanceof Node)) {
				return -1;
			}
			return this.key.compareTo(((Node) o).key);
		}

		public String toString() {
			return String.valueOf(this.key);
		}
	}

}
