package leetcode.hard;

public class P_65 {

    public boolean isNumber(String s) {
        s = s.toLowerCase();
        int e = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'e') {
                if (e == 1) {
                    return false;
                }
                e++;
            } else if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                return false;
            }
        }
        if (e == 0) {
            return s.indexOf('.') >= 0 ? isDecimal(s) : isInteger(s);
        }
        final String[] split = s.split("e", -1);
        return isNumber(split[0]) && isInteger(split[1]);
    }

    private static boolean isDecimal(String s) {
        int dotIdx = -1;
        boolean sign = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i > 0) {
                    return false;
                }
                sign = true;
            } else if (s.charAt(i) == '.') {
                if (dotIdx != -1) {
                    return false;
                }
                dotIdx = i;
            }
        }
        final int l = dotIdx - (sign ? 1 : 0);
        final int r = s.length() - (dotIdx + 1);
        return l > 0 || r > 0;
    }

    private static boolean isInteger(String s) {
        if (s.indexOf('.') >= 0) {
            return false;
        }
        int digits = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i > 0) {
                    return false;
                }
            } else {
                digits++;
            }
        }
        return digits > 0;
    }
}
