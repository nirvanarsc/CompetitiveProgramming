package weekly_contests.weekly_87;

public class P_844 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        while (true) {
            for (int back = 0; i >= 0 && (back > 0 || S.charAt(i) == '#'); --i) {
                back += S.charAt(i) == '#' ? 1 : -1;
            }
            for (int back = 0; j >= 0 && (back > 0 || T.charAt(j) == '#'); --j) {
                back += T.charAt(j) == '#' ? 1 : -1;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                return i == -1 && j == -1;
            }
        }
    }

    public boolean backspaceCompareInPlace(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipLeft = 0;
        int skipRight = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (skipLeft > 0 || s.charAt(i) == '#')) {
                if (s.charAt(i) == '#') {
                    skipLeft++;
                } else {
                    skipLeft--;
                }
                i--;
            }
            while (j >= 0 && (skipRight > 0 || t.charAt(j) == '#')) {
                if (t.charAt(j) == '#') {
                    skipRight++;
                } else {
                    skipRight--;
                }
                j--;
            }
            final int left = i >= 0 ? s.charAt(i) : '#';
            final int right = j >= 0 ? t.charAt(j) : '#';
            if (left != right) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
