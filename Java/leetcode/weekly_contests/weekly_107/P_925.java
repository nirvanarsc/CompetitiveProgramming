package leetcode.weekly_contests.weekly_107;

public class P_925 {

    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while (i < name.length() && j < typed.length()) {
            final char ll = name.charAt(i);
            final char rr = typed.charAt(j);
            if (ll != rr) {
                return false;
            }
            int iR = i;
            int jR = j;
            while (iR < name.length() && name.charAt(iR) == ll) {
                iR++;
            }
            while (jR < typed.length() && typed.charAt(jR) == rr) {
                jR++;
            }
            if (iR - i > jR - j) {
                return false;
            }
            i = iR;
            j = jR;
        }
        return i == name.length() && j == typed.length();
    }
}
