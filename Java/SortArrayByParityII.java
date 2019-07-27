public final class SortArrayByParityII {

    public static void main(String[] args) {
        final int[] arr = { 4, 2, 0, 10, 16, 5, 3, 1, 7, 9 };
        for (int i : sortArrayByParity1(arr)) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : sortArrayByParity2(arr)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private SortArrayByParityII() {}

    private static int[] sortArrayByParity1(int[] a) {
        final int[] res = new int[a.length];
        int even = 0;
        int odd = 1;
        for (int i : a) {
            if ((i & 1) == 0) {
                res[even] = i;
                even += 2;
            } else {
                res[odd] = i;
                odd += 2;
            }
        }
        return res;
    }

    // In place
    public static int[] sortArrayByParity2(int[] a) {
        int l = 0, r = 1;
        while (l < a.length) {
            if ((a[l] & 1) != 0) {
                final int temp = a[l];
                a[l] = a[r];
                a[r] = temp;
                r += 2;
            } else {
                l += 2;
            }
        }
        return a;
    }
}
