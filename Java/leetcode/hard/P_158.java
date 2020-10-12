package leetcode.hard;

public class P_158 {

    int read4(char[] buf) {
        return 0;
    }

    private int buffPtr;
    private int buffCnt;
    private final char[] buff = new char[4];

    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (buffPtr == buffCnt) {
                buffPtr = 0;
                buffCnt = read4(buff);
            }
            if (buffCnt == 0) {
                break;
            }
            while (ptr < n && buffPtr < buffCnt) {
                buf[ptr++] = buff[buffPtr++];
            }
        }
        return ptr;
    }
}
