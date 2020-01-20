package easy;

public class P_459 {

    public boolean repeatedSubstringPatternImproved(String s) {
        final int l = s.length();
        for (int i = l / 2; i >= 1; i--) {
            if (l % i == 0) {
                final int t = l / i;
                final String subS = s.substring(0, i);
                int j;
                for (j = 1; j < t; j++) {
                    if (!subS.equals(s.substring(j * i, i + j * i))) {
                        break;
                    }
                }
                if (j == t) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern(String s) {
        final int l = s.length();
        for (int i = 1; i <= l / 2; i++) {
            if (l % i == 0) {
                final StringBuilder sb = new StringBuilder();
                for (int t = 0; t < l / i; t++) {
                    sb.append(s, 0, i);
                }
                if (s.equals(sb.toString())) {
                    return true;
                }
            }
        }
        return false;
    }
}
