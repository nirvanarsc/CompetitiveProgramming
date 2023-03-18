package leetcode.biweekly_contests.biweekly_0_99.biweekly_13;

public class P_1256 {

    public String encode(int num) {
        return Integer.toBinaryString(num + 1).substring(1);
    }
}
