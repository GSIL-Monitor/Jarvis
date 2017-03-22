package algorithm.sort.base;

import factory.NumFactory;
import util.NumUtil;

/**
 * @Description
 * @Author liuxiao
 * @Date 2017/3/22
 */
public class SortActivity {

	private SortAlgorithm mSortAlgorithm;
	private int[] mNums;
	private int mRepeatTime;
	private int mNumSize;

	private long time;

	public SortActivity() {
		this.mNumSize = 50;
	}

	/**
	 * set number array length
	 * @param numSize
	 */
	public SortActivity(int numSize) {
		this.mNumSize = numSize;
	}

	public void doSort(SortAlgorithm sortAlgorithm) {
		this.mSortAlgorithm = sortAlgorithm;
		this.mNums = NumFactory.getRandomNums(mNumSize);
		this.mRepeatTime = 1 << 16;
		onBeforeSort();
		onDoSort();
		onRepeatSort();
		onAfterSort();
	}

	private void onBeforeSort() {
		System.out.println(mSortAlgorithm.getClass().getSimpleName());
		System.out.print("Before: ");
		NumUtil.print(mNums);
		time = System.currentTimeMillis();
	}

	private void onDoSort() {
		mSortAlgorithm.sort(mNums);
	}

	/**
	 * repeat sort $repeatTime$ times, in order to let the time count be obvious
	 */
	private void onRepeatSort() {
		for (int i = 0; i < mRepeatTime; i++) {
			mSortAlgorithm.sort(NumFactory.getRandomNums(mNumSize));
		}
	}

	private void onAfterSort() {
		System.out.print("After:  ");
		NumUtil.print(mNums);
		System.out.println(String.format("Time:  %s ms\n", System.currentTimeMillis() - time));
	}

}
