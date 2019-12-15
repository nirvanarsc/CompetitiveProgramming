package medium;

import java.util.ArrayList;
import java.util.List;

public final class P_93 {

    public static List<String> restoreIpAddresses(String s) {
        final List<String> res = new ArrayList<>();
        for (int a = 1; a <= 3; a++) {
            for (int b = a + 1; b <= a + 3; b++) {
                for (int c = b + 1; c <= b + 3; c++) {
                    for (int d = c + 1; d <= c + 3; d++) {
                        if (d == s.length()) {
                            final String s1 = s.substring(0, a);
                            final String s2 = s.substring(a, b);
                            final String s3 = s.substring(b, c);
                            final String s4 = s.substring(c, d);
                            if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                                res.add(s1 + '.' + s2 + '.' + s3 + '.' + s4);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static boolean isValid(String s) {
        return (s.charAt(0) != '0' || s.length() <= 1) && Integer.parseInt(s) <= 255;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("010010"));
    }

    private P_93() {}
}
