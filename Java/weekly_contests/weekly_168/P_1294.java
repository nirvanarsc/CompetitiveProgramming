package weekly_contests.weekly_168;

public final class P_1294 {

    public static int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            if (getDigits(num) % 2 == 0) {
                res++;
            }
        }
        return res;
    }

    private static int getDigits(int num) {
        int res = 0;
        while (num != 0) {
            num /= 10;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findNumbers(new int[] { 12, 345, 2, 6, 7896 }));
        System.out.println(findNumbers(new int[] { 555, 901, 482, 1771 }));
    }

    private P_1294() {}
}
