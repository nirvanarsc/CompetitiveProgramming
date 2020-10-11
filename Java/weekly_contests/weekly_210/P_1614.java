package weekly_contests.weekly_210;

public class P_1614 {

    public int maxDepth(String s) {
        int open = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                res = Math.max(res, ++open);
            } else if (c == ')') {
                open -= 1;
            }
        }
        return res;
    }
}
