package weekly_contests.weekly_170;

public class P_1309 {

    public String freqAlphabets(String s) {
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (checkHash(s, i)) {
                sb.append(Character.toChars(96 + Integer.parseInt(s.substring(i, i + 2))));
                i += 2;
            } else {
                sb.append(Character.toChars(96 + Integer.parseInt(s.substring(i, i + 1))));
            }
        }

        return sb.toString();
    }

    private static boolean checkHash(String s, int start) {
        if (start >= s.length() - 2) {
            return false;
        }

        return s.charAt(start + 2) == '#';
    }
}
