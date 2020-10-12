package leetcode.weekly_contests.weekly_154;

public class P_1189 {

    public int maxNumberOfBalloons(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        for (char c : text.toCharArray()) {
            if (c == 'b') { b++; }
            if (c == 'a') { a++; }
            if (c == 'l') { l++; }
            if (c == 'o') { o++; }
            if (c == 'n') { n++; }
        }
        int res = Integer.MAX_VALUE;
        res = Math.min(res, b);
        res = Math.min(res, a);
        res = Math.min(res, l / 2);
        res = Math.min(res, o / 2);
        res = Math.min(res, n);
        return res;
    }
}
