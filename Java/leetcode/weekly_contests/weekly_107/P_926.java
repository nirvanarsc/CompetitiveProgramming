package leetcode.weekly_contests.weekly_107;

public class P_926 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int minFlipsMonoIncr(String S) {
        int zeroes = 0, ones = 0;
        for (char c : S.toCharArray()) {
            if (c == '1') {
                ++ones;
            } else {
                ++zeroes;
            }
            zeroes = Math.min(ones, zeroes);
        }
        return zeroes;
    }
}
