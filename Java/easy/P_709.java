package easy;

public class P_709 {

    public String toLowerCase(String str) {
        final char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ('A' <= chars[i] && chars[i] <= 'Z') {
                chars[i] += ' ';
            }
        }
        return new String(chars);
    }

    public String toLowerCaseBitwise(String str) {
        final char[] chars = str.toCharArray();
        final int space = 1 << 5;
        for (int i = 0; i < chars.length; i++) {
            if ('A' <= chars[i] && chars[i] <= 'Z') {
                chars[i] |= space;
            }
        }
        return new String(chars);
    }
}
