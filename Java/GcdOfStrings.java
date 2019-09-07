public final class GcdOfStrings {

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(gcdOfStrings("LEET", "CODE"));
    }

    private static String gcdOfStrings(String str1, String str2) {
        final StringBuilder sb = new StringBuilder();
        final StringBuilder s1 = new StringBuilder(str1);
        final StringBuilder s2 = new StringBuilder(str2);
        final int gcd = gcd(str1.length(), str2.length());
        final int lcm = (str1.length() * str2.length()) / gcd;
        int left = lcm / str1.length();
        int right = lcm / str2.length();
        while (--left > 0) { s1.append(str1); }
        while (--right > 0) { s2.append(str2); }
        if (s1.toString().equals(s2.toString())) {
            for (int i = 0; i < gcd; i++) {
                sb.append(str1.charAt(i));
            }
        }
        return sb.toString();
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            final int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
