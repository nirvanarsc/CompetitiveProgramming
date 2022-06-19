package leetcode.weekly_contests.weekly_200_299.weekly_298;

public class P_1 {

    public String greatestLetter(String s) {
        int l = 0;
        int r = 0;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                r |= 1 << c - 'A';
            } else {
                l |= 1 << c - 'a';
            }
        }
        for (int i = 25; i >= 0; i--) {
            if ((r & (1 << i)) != 0 && (l & (1 << i)) != 0) {
                return String.valueOf((char) ('A' + i));
            }
        }
        return "";
    }
}
