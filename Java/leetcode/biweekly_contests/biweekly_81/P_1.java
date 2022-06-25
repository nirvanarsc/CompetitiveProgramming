package leetcode.biweekly_contests.biweekly_81;

public class P_1 {

    public int countAsterisks(String s) {
        int z = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '|') {
                z++;
            }
            if (z % 2 == 0) {
                if (c == '*') {
                    res++;
                }
            }
        }
        return res;
    }
}
