public final class PeakIndexMountainArray {

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[] { 0, 1, 0 }));
        System.out.println(peakIndexInMountainArray(new int[] { 0, 2, 1, 0 }));
    }

    public static int peakIndexInMountainArray(int[] a) {
        int max = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
                res = i;
            }
        }

        return res;
    }

    private PeakIndexMountainArray() {}
}
