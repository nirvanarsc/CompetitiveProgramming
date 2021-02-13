package foobar.level_2;

public final class B {

    public static void main(String[] args) {
        System.out.println(solution(">----<"));
        System.out.println(solution("<<>><"));
        System.out.println(solution("--->-><-><-->-"));
    }

    public static int solution(String s) {
        final char[] w = s.toCharArray();
        int res = 0;
        final int[] opposite = new int[w.length];
        int curr = 0;
        for (int i = w.length - 1; i >= 0; i--) {
            if (w[i] == '<') {
                curr++;
            }
            opposite[i] = curr;
        }
        for (int i = 0; i < w.length; i++) {
            if (w[i] == '>') {
                res += opposite[i];
            }
        }
        return res * 2;
    }
}

