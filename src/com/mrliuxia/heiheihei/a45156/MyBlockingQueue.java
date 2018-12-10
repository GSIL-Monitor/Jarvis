package com.mrliuxia.heiheihei.a45156;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Date 2017/3/19
 */
public class MyBlockingQueue<E> {

	final Object[] items;
	final ReentrantLock lock;
	int putIndex;
	int takeIndex;
	int count;

	final Condition notEmpty;
	final Condition notFull;

	public MyBlockingQueue(int capacity) {
		this(capacity, false);
	}

	public MyBlockingQueue(int capacity, boolean fair) {
		if (capacity <= 0)
			throw new IllegalArgumentException();
		this.items = new Object[capacity];
		lock = new ReentrantLock(fair);
		notEmpty = lock.newCondition();
		notFull =  lock.newCondition();
	}

	public void put(E e) throws InterruptedException {
		checkNotNull(e);
		final ReentrantLock lock = this.lock;
		lock.lockInterruptibly();
		try {
			while (count == items.length)
				notFull.await();
			enqueue(e);
		} finally {
			lock.unlock();
		}
	}

	public E take() throws InterruptedException {
		final ReentrantLock lock = this.lock;
		lock.lockInterruptibly();
		try {
			while (count == 0)
				notEmpty.await();
			return dequeue();
		} finally {
			lock.unlock();
		}
	}

	private void enqueue(E x) {
		final Object[] items = this.items;
		items[putIndex] = x;
		if (++putIndex == items.length)
			putIndex = 0;
		count++;
		notEmpty.signal();
	}

	private E dequeue() {
		final Object[] items = this.items;
		@SuppressWarnings("unchecked")
		E x = (E) items[takeIndex];
		items[takeIndex] = null;
		if (++takeIndex == items.length)
			takeIndex = 0;
		count--;

		notFull.signal();
		return x;
	}

	private void checkNotNull(Object v) {
		if (v == null)
			throw new NullPointerException();
	}


}
