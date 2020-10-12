package leetcode.biweekly_contests.biweekly_15;

public final class P_1287 {

    public static int findSpecialInteger(int[] arr) {
        final int times = arr.length / 4;
        int count = 1;
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == prev) {
                count++;
                if (count > times) {
                    return arr[i];
                }
            } else {
                prev = arr[i];
                count = 1;
            }
        }

        return prev;
    }

    public static void main(String[] args) {
        System.out.println(findSpecialInteger(new int[] { 1, 2, 2, 6, 6, 7, 7, 7, 10 }));
    }

    private P_1287() {}
}
