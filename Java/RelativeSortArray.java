public final class RelativeSortArray {

    public static void main(String[] args) {
        final int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
        final int[] arr2 = { 2, 1, 4, 3, 9, 6 };

        for (int i : relativeSortArray(arr1, arr2)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        final int max_number = 1001;
        final int[] map = new int[max_number];
        final int[] ans = new int[arr1.length];
        int idx = 0;
        for (int i : arr1) {
            map[i]++;
        }
        for (int i : arr2) {
            while (map[i]-- > 0) {
                ans[idx++] = i;
            }
        }
        for (int i = 0; i < max_number; i++) {
            while (map[i]-- > 0) {
                ans[idx++] = i;
            }
        }

        return ans;
    }

    private RelativeSortArray() {}
}
