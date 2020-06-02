package easy;

public class P_157 {

    int read4(char[] buf) {
        return 0;
    }

    public int read(char[] buf, int n) {
        int res = 0, read = 4;
        final char[] buffer = new char[4];
        while (n > 0 && read > 0) {
            read = read4(buffer);
            System.arraycopy(buffer, 0, buf, res, Math.min(n, read));
            res += Math.min(n, read);
            n -= read;
        }
        return res;
    }
}
