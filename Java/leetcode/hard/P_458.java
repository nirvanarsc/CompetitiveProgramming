package leetcode.hard;

public class P_458 {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // i.e. 15/15 => 2 states (alive, dead) => log 2 1024 = 10
        final int states = minutesToTest / minutesToDie + 1;
        return (int) Math.ceil(Math.log(buckets) / Math.log(states));
    }
}
