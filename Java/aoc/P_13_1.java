package aoc;

public final class P_13_1 {

    public static void main(String[] args) {
        final int n = 1000104;
        final String input =
                "41,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,37,x,x,x,x,"
                + "x,659,x,x,x,x,x,x,x,23,x,x,x,x,13,x,x,x,x,x,19,x,x,x,x,x,x,x,x,x,29,x,937,x,x,x,"
                + "x,x,x,x,x,x,x,x,x,x,x,x,x,17";
        long res = (long) 1e18;
        long smallest = (long) 1e18;
        for (String split : input.split(",")) {
            if ("x".equals(split)) {
                continue;
            }
            final long curr = Long.parseLong(split);
            long rem = n % curr;
            if (rem > 0) {
                rem = curr - rem;
            }
            if (smallest > rem) {
                smallest = rem;
                res = rem * curr;
            }
        }
        System.out.println(res);
    }
}
