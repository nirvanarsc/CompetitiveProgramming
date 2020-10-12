package leetcode.easy;

public class P_266 {

    public boolean canPermutePalindrome(String s) {
        int odds = 0;
        final int[] map = new int[128];
        for (char c : s.toCharArray()) {
            map[c]++;
        }
        for (int freq : map) {
            odds += freq % 2;
        }
        return odds <= 1;
    }
}
