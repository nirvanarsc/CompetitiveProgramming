package leetcode.biweekly_contests.biweekly_32;

public class P_1541 {

    public int minInsertions(String s) {
        int res = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { // => (
                left++;
            } else if (i == s.length() - 1 || s.charAt(i + 1) == '(') { // => )
                if (left > 0) {
                    res++;
                    left--;
                } else {
                    res += 2;
                }
            } else { // => ))
                if (left > 0) {
                    left--;
                } else {
                    res++;
                }
                i++; // advance pointer since we have processed two ) at once
            }
        }
        return res + left * 2;
    }
}
