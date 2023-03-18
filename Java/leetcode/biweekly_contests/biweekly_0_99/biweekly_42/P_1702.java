package leetcode.biweekly_contests.biweekly_0_99.biweekly_42;

import java.util.Arrays;

public class P_1702 {

    public String maximumBinaryString(String binary) {
        char[] res = binary.toCharArray();
        int zeroes = 0;
        int firstZero = -1;
        for (int i = 0; i < res.length; i++) {
            if (res[i] == '0') {
                zeroes++;
                if (firstZero == -1) {
                    firstZero = i;
                }
            }
        }
        if (zeroes <= 1) {
            return new String(res);
        }
        res = new char[binary.length()];
        Arrays.fill(res, '1');
        res[firstZero + zeroes - 1] = '0';
        return new String(res);
    }
}
