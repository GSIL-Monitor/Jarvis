package leetcode;

/**
 * Created by Poker on 2016/11/13.
 */
public class _4_MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums2 = {10, 11, 12};
        int[] nums1 = {1};
        System.out.println(new _4_MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            double res = ((double) nums2[(nums2.length - 1) / 2] + (double) nums2[nums2.length / 2]) / 2;
            return res;
        }
        if (nums2.length == 0) {
            double res = ((double) nums1[(nums1.length - 1) / 2] + (double) nums1[nums1.length / 2]) / 2;
            return res;
        }
        int totalLen = nums1.length + nums2.length;
        int fmIndex = (totalLen - 1) / 2;
        int lmIndex = totalLen / 2;
        double fMedian = 0;
        double lMedian = 0;
        int f = 0;
        int l = 0;
        for (int i = 0; i <= fmIndex; i++) {
            if (l == nums2.length) {
                fMedian = nums1[f++];
                continue;
            }
            if (f == nums1.length) {
                fMedian = nums2[l++];
                continue;
            }
            fMedian = nums1[f] < nums2[l] ? nums1[f++] : nums2[l++];
        }
        if (totalLen % 2 == 1) {
            return fMedian;
        }
        if (l == nums2.length || f == nums1.length) {
            lMedian = l == nums2.length ? nums1[f] : nums2[l];
        } else {
            lMedian = nums1[f] < nums2[l] ? nums1[f] : nums2[l];
        }
        return (fMedian + lMedian) / 2;
    }

}
