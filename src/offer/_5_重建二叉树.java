package offer;

import java.util.Arrays;

/**
 * 给出前序遍历和中序遍历
 * <p>
 * Created by Poker on 2016/11/2.
 */
public class _5_重建二叉树 {


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums,0,4)));
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode rootNode = new TreeNode(pre[0]);
        int leftSize = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                leftSize = i;
                break;
            }
        }
        if (leftSize != 0) {
            int[] leftPre = Arrays.copyOfRange(pre, 1, leftSize+1);
            int[] leftIn = Arrays.copyOfRange(in, 0, leftSize);
            rootNode.left = reConstructBinaryTree(leftPre, leftIn);
        } else {
            rootNode.left = null;
        }
        if (leftSize != pre.length-1) {
            int[] rightPre = Arrays.copyOfRange(pre, leftSize+1, pre.length);
            int[] rightIn = Arrays.copyOfRange(in, leftSize+1, in.length);
            rootNode.right = reConstructBinaryTree(rightPre, rightIn);
        } else {
            rootNode.right = null;
        }
        return rootNode;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}