package easy;

public class P_551 {

    public boolean checkRecordSimplified(String s) {
        int late = 0;
        int absent = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                late++;
            } else {
                late = 0;
            }
            if (c == 'A') {
                absent++;
            }
            if (late > 2 || absent > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean checkRecordSmart(String s) {
        return s.indexOf('A') == s.lastIndexOf('A') && !s.contains("LLL");
    }

    public boolean checkRecord(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int absent = s.charAt(0) == 'A' ? 1 : 0;
        int late = s.charAt(0) == 'L' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            final char curr = s.charAt(i);
            if (s.charAt(i - 1) == 'L' && curr == 'L') {
                if (late == 2) {
                    return false;
                }
                late++;
            } else if (curr == 'L') {
                late = 1;
            } else {
                late = 0;
            }
            if (curr == 'A' && absent == 1) {
                return false;
            } else if (curr == 'A') {
                absent++;
            }
        }
        return true;
    }
}
