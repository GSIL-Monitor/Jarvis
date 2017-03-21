package algorithm.sort;

import factory.NumFactory;
import util.NumUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author liuxiao
 * @Date 2017/3/15
 */
public class Sorting {

	private long startTime;

	public static void main(String[] args) {
		Sorting mSorting = new Sorting();
		mSorting.doSort(new BubbleSort());
		mSorting.doSort(new SelectSort());
		mSorting.doSort(new InsertSort());
		mSorting.doSort(new ShellSort());
		mSorting.doSort(new QuickSort());
		mSorting.doSort(new MergeSort());
		mSorting.doSort(new HeapSort());
		mSorting.doSort(new RadixSort());
	}

	private void doSort(SortAlgorithm clazz) {
		try {
			Method sortMethod = clazz.getClass().getDeclaredMethod("sort", int[].class);
			int[] nums = NumFactory.getRandomNums(500, 1000);
			onBeforeSort(clazz, nums);
			sortMethod.invoke(clazz, nums);
			onAfterSort(clazz, nums);
		} catch (NoSuchMethodException e) {
			System.out.println("Reflect method error");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			System.out.println("Method inner exception");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("Method isn't public");
			e.printStackTrace();
		}
	}

	private void onBeforeSort(SortAlgorithm clazz, int[] nums) {
		System.out.println(clazz.getClass().getSimpleName());
		System.out.print("Before: ");
		NumUtil.print(nums);
		startTime = System.currentTimeMillis();
	}

	private void onAfterSort(SortAlgorithm clazz, int[] nums) {
		long time = System.currentTimeMillis() - startTime;
		System.out.print("After:  ");
		NumUtil.print(nums);
		System.out.println("Time:  " + time + " ms\n");
	}

}