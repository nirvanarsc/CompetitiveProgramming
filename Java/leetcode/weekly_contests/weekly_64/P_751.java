package leetcode.weekly_contests.weekly_64;

import java.util.ArrayList;
import java.util.List;

public class P_751 {

    public List<String> ipToCIDR(String ip, int n) {
        long remaining = n;
        long ipValue = ipToValue(ip);
        final List<String> list = new ArrayList<>();
        while (remaining > 0) {
            final long a = Long.lowestOneBit(ipValue);
            final long b = Long.highestOneBit(remaining);
            final long block = a == 0 ? b : Math.min(a, b);
            final String cidr = valueToIp(ipValue) + '/' + (32 - Long.numberOfTrailingZeros(block));
            list.add(cidr);
            ipValue += block;
            remaining -= block;
        }
        return list;
    }

    private static long ipToValue(String ip) {
        final String[] temp = ip.split("\\.");
        long res = 0;
        for (int i = 0; i < temp.length; i++) {
            res |= Long.parseLong(temp[i]) << (3 - i) * Byte.SIZE;
        }
        return res;
    }

    private static String valueToIp(long ipValue) {
        final int _255 = 0xFF;
        return String.format("%d.%d.%d.%d", ipValue >>> 24, ipValue >>> 16 & _255, ipValue >>> 8 & _255, ipValue & _255);
    }
}
