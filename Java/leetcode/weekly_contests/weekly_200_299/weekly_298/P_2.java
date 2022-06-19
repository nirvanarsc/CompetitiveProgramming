package leetcode.weekly_contests.weekly_200_299.weekly_298;

public class P_2 {

    public int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }
        if (k == 0) {
            return num % 10 == 0 ? 1 : -1;
        }
        final int r = num % 10;
        int d = 1;
        int sum = k;
        while (num >= sum && r != sum % 10) {
            sum += k;
            d++;
        }
        return r == sum % 10 ? d : -1;
    }
}
