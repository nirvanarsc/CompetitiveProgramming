package leetcode.weekly_contests.weekly_200_299.weekly_295;

public class P_2 {

    public String discountPrices(String sentence, int discount) {
        final String[] split = sentence.split(" ");
        final StringBuilder res = new StringBuilder();
        for (String w : split) {
            if (w.charAt(0) == '$') {
                try {
                    final double curr = Double.parseDouble(w.substring(1));
                    res.append('$');
                    res.append(String.format("%.2f", (curr * (100 - discount)) / 100.0));
                } catch (NumberFormatException e) {
                    res.append(w);
                }
            } else {
                res.append(w);
            }
            res.append(' ');
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}
