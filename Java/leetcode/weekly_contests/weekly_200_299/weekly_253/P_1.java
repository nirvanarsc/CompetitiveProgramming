package leetcode.weekly_contests.weekly_200_299.weekly_253;

public class P_1 {

    public boolean isPrefixString(String s, String[] words) {
        final StringBuilder total = new StringBuilder();
        for (String w : words) {
            total.append(w);
            if (total.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
