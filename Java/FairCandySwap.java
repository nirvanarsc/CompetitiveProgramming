import java.util.Arrays;

public final class FairCandySwap {

    public static void main(String[] args) {
        final int[] a = { 21, 89, 90, 88, 54, 45, 67, 41, 57, 7 };
        final int[] b = { 55, 57, 22, 19, 44, 91, 100, 71, 33, 33 };
        System.out.println(Arrays.toString(fairCandySwap(a, b)));
    }

    public static int[] fairCandySwap(int[] a, int[] b) {
        int diff = 0;
        for (int i : a) { diff += i; }
        for (int i : b) { diff -= i; }

        final int[] res = new int[2];

        for (int i : a) {
            for (int j : b) {
                if (2 * (i - j) == diff) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }

        return res;
    }

    private FairCandySwap() {}
}
