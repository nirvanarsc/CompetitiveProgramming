package medium;

import java.util.Arrays;

public final class P_3 {

    public static int lengthOfLongestSubstring(String s) {
        final int[] map = new int[256];
        Arrays.fill(map, -1);
        int res = 0, start = 0, i = 0;
        for (; i < s.length(); i++) {
            if (map[s.charAt(i)] != -1) {
                res = Math.max(res, i - start);
                start = Math.max(start, map[s.charAt(i)] + 1);
            }
            map[s.charAt(i)] = i;
        }
        res = Math.max(res, i - start);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    private P_3() {}
}
