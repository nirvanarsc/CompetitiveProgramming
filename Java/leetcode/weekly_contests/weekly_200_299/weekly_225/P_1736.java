package leetcode.weekly_contests.weekly_200_299.weekly_225;

public class P_1736 {

    public String maximumTime(String time) {
        final char[] res = new char[5];
        res[2] = ':';
        if (time.charAt(0) == '?') {
            if (time.charAt(1) == '?') {
                res[0] = '2';
                res[1] = '3';
            } else {
                if (time.charAt(1) >= '4') {
                    res[0] = '1';
                } else {
                    res[0] = '2';
                }
                res[1] = time.charAt(1);
            }
        } else {
            res[0] = time.charAt(0);
            if (time.charAt(1) == '?') {
                if (time.charAt(0) == '2') {
                    res[1] = '3';
                } else {
                    res[1] = '9';
                }
            } else {
                res[1] = time.charAt(1);
            }
        }
        if (time.charAt(3) == '?') {
            res[3] = '5';
        } else {
            res[3] = time.charAt(3);
        }
        if (time.charAt(4) == '?') {
            res[4] = '9';
        } else {
            res[4] = time.charAt(4);
        }
        return new String(res);
    }
}
