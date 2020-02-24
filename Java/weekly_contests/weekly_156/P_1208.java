package weekly_contests.weekly_156;

public class P_1208 {

    public int equalSubstring(String s, String t, int maxCost) {
        int i = 0;
        int res = 0;
        for (int j = 0; j < s.length(); j++) {
            maxCost -= Math.abs(s.charAt(j) - t.charAt(j));
            while (maxCost < 0) {
                maxCost += Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
