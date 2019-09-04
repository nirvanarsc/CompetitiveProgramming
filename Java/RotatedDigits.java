public final class RotatedDigits {

    public static void main(String[] args) {
        System.out.println(rotatedDigits(10));
    }

    private static int rotatedDigits(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) { res++; }
        }
        return res;
    }

    private static boolean isGood(int i) {
        final int copy = i;
        int rotated = 0, idx = 1;
        while (i > 0) {
            int key = i % 10;
            if (key == 3 || key == 4 || key == 7) { return false; }
            if (key == 2 || key == 5) { key = 5 + 2 - key; }
            if (key == 6 || key == 9) { key = 6 + 9 - key; }
            rotated += idx * key;
            i /= 10;
            idx *= 10;
        }
        System.out.println(copy + " " + rotated);
        return rotated != copy;
    }
}
