package leetcode.weekly_contests.weekly_200_299.weekly_237;

public class P_1832 {

    public boolean checkIfPangram(String sentence) {
        int mask = 0;
        for (char c : sentence.toCharArray()) {
            mask |= 1 << c - 'a';
        }
        return Integer.bitCount(mask) == 26;
    }
}
