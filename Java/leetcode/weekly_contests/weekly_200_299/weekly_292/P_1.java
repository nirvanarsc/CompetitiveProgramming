package leetcode.weekly_contests.weekly_200_299.weekly_292;

public class P_1 {

    public String largestGoodInteger(String num) {
        final String[] arr = { "999", "888", "777", "666", "555", "444", "333", "222", "111", "000" };
        for (String s : arr) {
            if (num.contains(s)) {
                return s;
            }
        }
        return "";
    }
}
