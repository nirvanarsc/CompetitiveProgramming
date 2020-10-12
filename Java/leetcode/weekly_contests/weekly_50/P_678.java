package leetcode.weekly_contests.weekly_50;

public class P_678 {

    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == '*') {
                minOpen--;
                maxOpen++;
            } else {
                if (maxOpen == 0) {
                    return false;
                }
                minOpen--;
                maxOpen--;
            }
            minOpen = Math.max(minOpen, 0);
        }
        return minOpen == 0;
    }
}
