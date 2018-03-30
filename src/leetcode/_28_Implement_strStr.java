package leetcode;

/**
 * Author: liuxiao
 * Created: 2018/1/30 16:50
 * Description: KMP
 */
public class _28_Implement_strStr {

    public static void main(String[] args) {// FIXME: 2018/1/30 结果错误
        System.out.println(new _28_Implement_strStr().strStr("aabaaabaaac", "aabaaac"));
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.equals("")) {
            return 0;
        }
        return find(haystack.toCharArray(), needle.toCharArray());
    }

    public static int find(char[] source, char[] pattern) {
        int i = 0, j = 0;
        int sLen = source.length;
        int pLen = pattern.length;
        int[] next = getNext(pattern);
        while (i < sLen && j < pLen) {
            if (j == -1 || source[i] == pattern[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pLen) {
            return i - j;
        }
        return -1;
    }

    private static int[] getNext(char[] charSeq) {
        int[] next = new int[charSeq.length];
        next[0] = -1;
        int i = 1;
        int k = -1;
        while (i < charSeq.length - 1) {
            if (k == -1 || charSeq[i] == charSeq[k]) {
                i++;
                k++;
                next[i] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

}
