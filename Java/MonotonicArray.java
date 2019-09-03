public class MonotonicArray {

    public boolean isMonotonic(int[] a) {
        boolean inc = true, dec = true;
        for (int i = 1; i < a.length; i++) {
            inc &= a[i - 1] <= a[i];
            dec &= a[i - 1] >= a[i];
        }
        return inc || dec;
    }
}
