package foobar.level_1;

public final class A {

    public static void main(String[] args) {
        System.out.println(solution("Yvzs! I xzm'g yvorvev Lzmxv olhg srh qly zg gsv xlolmb!!"));
    }

    public static String solution(String x) {
        final char[] res = new char[x.length()];
        final char[] s = x.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if ('a' <= s[i] && s[i] <= 'z') {
                res[i] = (char) ('z' - (s[i] - 'a'));
            } else {
                res[i] = s[i];
            }
        }
        return new String(res);
    }
}
