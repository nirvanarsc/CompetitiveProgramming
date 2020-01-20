package easy;

public class P_7 {

    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        final int cast = (int) res;
        return res == cast ? cast : 0;
    }
}
