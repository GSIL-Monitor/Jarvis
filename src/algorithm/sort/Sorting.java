package algorithm.sort;

import algorithm.sort.algorithm.*;
import algorithm.sort.base.SortActivity;

/**
 * @Description
 * @Author liuxiao
 * @Date 2017/3/15
 */
public class Sorting {

	public static void main(String[] args) {
		SortActivity sortActivity = new SortActivity();
		sortActivity.doSort(new BubbleSort());
		sortActivity.doSort(new SelectSort());
		sortActivity.doSort(new InsertSort());
		sortActivity.doSort(new ShellSort());
		sortActivity.doSort(new QuickSort());
		sortActivity.doSort(new MergeSort());
		sortActivity.doSort(new HeapSort());
		sortActivity.doSort(new RadixSort());
	}

}