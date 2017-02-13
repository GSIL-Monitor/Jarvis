package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Poker on 2017/2/13.
 */
public class _3_LongestSubstrWithoutRepeatingChar {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end))+1);
            }
            map.put(s.charAt(end), end);
            max = Math.max(max, end - start+1);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            System.out.println(new _3_LongestSubstrWithoutRepeatingChar().lengthOfLongestSubstring(scan.next()));
        }
    }

}
