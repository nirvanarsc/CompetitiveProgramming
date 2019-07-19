public final class DeleteColumnsToSort {

    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[] { "zyx", "wvu", "tsr" }));
    }

    public static int minDeletionSize(String[] a) {
        final int l = a[0].length();
        final int n = a.length;
        int res = 0;
        char prev;
        for (int i = 0; i < l; i++) {
            prev = a[0].charAt(i);
            for (int k = 1; k < n; k++) {
                final char curr = a[k].charAt(i);
                if (prev > curr) {
                    res++;
                    break;
                }
                prev = curr;
            }
        }
        return res;
    }

    private DeleteColumnsToSort() {}
}
