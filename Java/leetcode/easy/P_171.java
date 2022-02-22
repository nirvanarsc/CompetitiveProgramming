package leetcode.easy;

public class P_171 {

    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (char c : columnTitle.toCharArray()) {
            res = res * 26 + c - 'A' + 1;
        }
        return res;
    }
}
