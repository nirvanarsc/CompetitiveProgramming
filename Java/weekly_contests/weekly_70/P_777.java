package weekly_contests.weekly_70;

public class P_777 {

    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", ""))) {
            return false;
        }
        int p = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != 'X') {
                while (p < start.length() && end.charAt(p) == 'X') {
                    p++;
                }
                if (start.charAt(i) == 'R' && i > p) {
                    return false;
                }
                if (start.charAt(i) == 'L' && i < p) {
                    return false;
                }
                p++;
            }
        }
        return true;
    }
}
