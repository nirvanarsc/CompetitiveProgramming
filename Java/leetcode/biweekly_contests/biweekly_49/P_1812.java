package leetcode.biweekly_contests.biweekly_49;

public class P_1812 {

    public boolean squareIsWhite(String coordinates) {
        final int row = 8 - coordinates.charAt(1) - '0';
        final int col = coordinates.charAt(0) - 'a';
        return (row + col) % 2 == 0;
    }
}
