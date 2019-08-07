public final class ReverseString {

    public static void main(String[] args) {
        final char[] s = "string".toCharArray();
        reverseString(s);
        System.out.println(new String(s));
    }

    public static void reverseString(char[] s) {
        for (int start = 0, end = s.length - 1; start < end; start++, end--) {
            if (s[start] != s[end]) {
                s[start] ^= s[end];
                s[end] ^= s[start];
                s[start] ^= s[end];
            }
        }
    }

    private ReverseString() {}
}
