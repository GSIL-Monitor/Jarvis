package leetcode;

/**
 * Created by Poker on 2017/2/20.
 */
public class _11_ContainerWithMostWater {

    public int maxArea(int[] height) {
        int lowIndex = 0;
        int hignIndex = height.length - 1;
        int maxArea = 0;
        while (lowIndex < hignIndex) {
            maxArea = Math.max(maxArea, Math.min(height[lowIndex], height[hignIndex]) * (hignIndex - lowIndex));
            if (height[lowIndex] < height[hignIndex]) {
                hignIndex--;
            }else {
                lowIndex++;
            }
        }
        return maxArea;
    }

}
