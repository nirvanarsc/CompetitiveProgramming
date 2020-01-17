package easy;

import java.util.regex.Pattern;

public class P_1108 {

    private static final Pattern PATTERN = Pattern.compile("\\.");

    public String defangIPaddrSB(String address) {
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                sb.append("[.]");
            } else {
                sb.append(address.charAt(i));
            }
        }

        return sb.toString();
    }

    public String defangIPaddr(String address) {
        return PATTERN.matcher(address).replaceAll("[.]");
    }
}
