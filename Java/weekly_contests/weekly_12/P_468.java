package weekly_contests.weekly_12;

public class P_468 {

    public String validIPAddress(String ip) {
        if (ip.contains("-")) {
            return "Neither";
        }
        if (ip.contains(".")) {
            return parseIPv4(ip);
        }
        if (ip.contains(":")) {
            return parseIPv6(ip);
        }
        return "Neither";
    }

    private static String parseIPv4(String ip) {
        final String[] split = ip.split("\\.", -1);
        if (split.length != 4) {
            return "Neither";
        }
        for (String add : split) {
            if (add.length() > 1 && add.charAt(0) == '0') {
                return "Neither";
            }
            try {
                if (Integer.parseInt(add) > 255) {
                    return "Neither";
                }
            } catch (NumberFormatException e) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    private static String parseIPv6(String ip) {
        final String[] split = ip.split(":", -1);
        if (split.length != 8) {
            return "Neither";
        }
        for (String add : split) {
            if (add.length() > 4) {
                return "Neither";
            }
            try {
                Integer.parseInt(add, 16);
            } catch (NumberFormatException e) {
                return "Neither";
            }
        }
        return "IPv6";
    }
}
