package leetcode.weekly_contests.weekly_211;

public class P_1624 {

    public int maxLengthBetweenEqualCharacters(String s) {
        int res = -1;
        for (char c = 'a'; c <= 'z'; c++) {
            int curr = -1;
            int j = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c && j != -1) {
                    curr = Math.max(curr, i - j - 1);
                } else if (s.charAt(i) == c) {
                    j = i;
                }
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
