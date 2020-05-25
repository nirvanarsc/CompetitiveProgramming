package medium;

public class P_8 {

    public int myAtoi(String str) {
        int j = 0;
        while (j < str.length() && str.charAt(j) == ' ') {
            j++;
        }
        if (j == str.length()
            || (str.charAt(j) != '-' && str.charAt(j) != '+' && !Character.isDigit(str.charAt(j)))) {
            return 0;
        }
        boolean sign = true;
        if (str.charAt(j) == '-' || str.charAt(j) == '+') {
            sign = str.charAt(j) == '+';
            j++;
        }
        int res = 0;
        while (j < str.length() && Character.isDigit(str.charAt(j))) {
            final int curr = Character.getNumericValue(str.charAt(j));
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && curr > 7) {
                return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + curr;
            j++;
        }
        return sign ? res : -res;
    }


}
