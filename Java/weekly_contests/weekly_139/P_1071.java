package weekly_contests.weekly_139;

public class P_1071 {

    public int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }

    public String gcdOfStrings(String str1, String str2) {
        final int d = gcd(str1.length(), str2.length());
        final String s = str1.substring(0, d);
        final String str = str1 + str2;
        for (int i = 0; i < str1.length() + str2.length(); i += d) {
            if (!str.startsWith(s, i)) {
                return "";
            }
        }
        return s;
    }

    public String gcdOfStringsSlow(String str1, String str2) {
        final int gcd = gcd(str1.length(), str2.length());
        final StringBuilder sb1 = new StringBuilder();
        final StringBuilder sb2 = new StringBuilder();
        final String s1 = str1.substring(0, gcd);
        final String s2 = str2.substring(0, gcd);
        if (!s1.equals(s2)) {
            return "";
        }
        while (sb1.length() < str1.length()) {
            sb1.append(s1);
        }
        while (sb2.length() < str2.length()) {
            sb2.append(s1);
        }
        return sb1.toString().equals(str1) && sb2.toString().equals(str2) ? s1 : "";
    }
}
