public final class SmallestRangeI {

    public static void main(String[] args) {
        System.out.println(smallestRangeI(new int[] { 0, 10 }, 2));
        System.out.println(smallestRangeI(new int[] { 1, 3, 6 }, 3));
    }

    public static int smallestRangeI(int[] a, int k) {
        if (a.length == 1) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : a) {
            if (min > i) {
                min = i;
            }
            if (max < i) {
                max = i;
            }
        }

        return Math.max(0, max - min - 2 * k);
    }

    private SmallestRangeI() {}
}
