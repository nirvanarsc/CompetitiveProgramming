package leetcode.weekly_contests.weekly_200_299.weekly_231;

public class P_1784 {

    public boolean checkOnesSegment(String s) {
        int seg = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                int j = i;
                while (j < s.length() && s.charAt(j) == '1') {
                    j++;
                }
                seg++;
                i = j - 1;
            }
        }
        return seg <= 1;
    }
}
