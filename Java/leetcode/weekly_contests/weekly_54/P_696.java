package leetcode.weekly_contests.weekly_54;

public class P_696 {

    public int countBinarySubstrings(String s) {
        char prevC = s.charAt(0);
        int prev = 0;
        int curr = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (prevC != c) {
                ans += Math.min(curr, prev);
                prev = curr;
                curr = 0;
            }
            curr++;
            prevC = c;
        }
        return ans + Math.min(curr, prev);
    }
}
