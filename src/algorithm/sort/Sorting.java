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
        //默认数组长度为50，可以通过传入int的方式自定义数组大小
        SortActivity sortActivity = new SortActivity();
        sortActivity.doSort(BubbleSort.class);
        sortActivity.doSort(SelectSort.class);
        sortActivity.doSort(InsertSort.class);
        sortActivity.doSort(ShellSort.class);
        sortActivity.doSort(QuickSort.class);
        sortActivity.doSort(MergeSort.class);
        sortActivity.doSort(HeapSort.class);
        sortActivity.doSort(RadixSort.class);
    }

}