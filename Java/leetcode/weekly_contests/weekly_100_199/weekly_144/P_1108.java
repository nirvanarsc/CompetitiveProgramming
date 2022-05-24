package leetcode.weekly_contests.weekly_100_199.weekly_144;

import java.util.regex.Pattern;

public class P_1108 {

    public String defangIPaddr(String address) {
        final StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                sb.append("[.]");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String defangIPaddrPattern(String address) {
        return Pattern.compile("\\.").matcher(address).replaceAll("[.]");
    }
}
