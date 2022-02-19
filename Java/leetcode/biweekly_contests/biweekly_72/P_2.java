package leetcode.biweekly_contests.biweekly_72;

public class P_2 {

    public long[] sumOfThree(long num) {
        if (num % 3 != 0) {
            //noinspection ZeroLengthArrayAllocation
            return new long[0];
        }
        return new long[] { (num / 3) - 1, num / 3, (num / 3) + 1 };
    }
}
