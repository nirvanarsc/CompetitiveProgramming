package leetcode.weekly_contests.weekly_100_199.weekly_143;

public class P_1105 {

    public int minHeightShelves(int[][] books, int shelf_width) {
        return recurse(books, 0, shelf_width, 0, 0, new Integer[books.length][shelf_width + 1]);
    }

    private static int recurse(int[][] books, int i, int maxW, int currH, int currW, Integer[][] dp) {
        if (books.length == i) { return currH; }
        if (dp[i][currW] != null) { return dp[i][currW]; }

        int place = Integer.MAX_VALUE;
        if (currW + books[i][0] <= maxW) {
            place = recurse(books, i + 1, maxW, Math.max(currH, books[i][1]), currW + books[i][0], dp);
        }
        final int placeOnNewShelf = currH + recurse(books, i + 1, maxW, books[i][1], books[i][0], dp);

        return dp[i][currW] = Math.min(place, placeOnNewShelf);
    }
}
