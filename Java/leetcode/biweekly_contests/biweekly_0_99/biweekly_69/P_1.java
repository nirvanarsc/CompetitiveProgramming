package leetcode.biweekly_contests.biweekly_0_99.biweekly_69;

public class P_1 {

    public String capitalizeTitle(String title) {
        final String[] words = title.split(" ");
        final StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (w.length() < 3) {
                sb.append(w.toLowerCase());
            } else {
                sb.append(Character.toUpperCase(w.charAt(0)));
                sb.append(w.substring(1).toLowerCase());
            }
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
