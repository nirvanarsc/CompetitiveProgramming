package easy;

public class P_443 {

    public int compress(char[] chars) {
        int read = 1, write = 0;
        while (read <= chars.length) {
            final char c = chars[read - 1];
            int t = 1;
            while (read < chars.length && chars[read - 1] == chars[read]) {
                read++;
                t++;
            }
            chars[write] = c;
            if (t > 1) {
                for (char tChar : String.valueOf(t).toCharArray()) {
                    chars[++write] = tChar;
                }
            }
            write += 1;
            read++;
        }
        return write;
    }
}
