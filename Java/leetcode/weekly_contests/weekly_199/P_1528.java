package leetcode.weekly_contests.weekly_199;

public class P_1528 {

    public String restoreString(String s, int[] indices) {
        final char[] res = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            res[indices[i]] = s.charAt(i);
        }
        return new String(res);
    }
}
