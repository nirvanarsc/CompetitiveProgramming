package hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_273 {

    private static final String[] SINGLE = {
            "", "One ", "Two ", "Three ", "Four ", "Five ",
            "Six ", "Seven ", "Eight ", "Nine "
    };
    private static final String[] LESS_20 = {
            "", "One ", "Two ", "Three ", "Four ", "Five ", "Six ",
            "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ",
            "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ",
            "Seventeen ", "Eighteen ", "Nineteen "
    };
    private static final String[] OVER_20 = {
            "", "", "Twenty ", "Thirty ", "Forty ", "Fifty ",
            "Sixty ", "Seventy ", "Eighty ", "Ninety "
    };
    private static final String[] THOUSAND = { "", "Thousand ", "Million ", "Billion " };

    public String numberToWords(int num) {
        if (num == 0) { return "Zero"; }
        final StringBuilder sb = new StringBuilder();
        final Deque<Integer> process = new ArrayDeque<>();
        int i = 0;
        while (num > 0) {
            process.addFirst(num % 1000);
            i++;
            num /= 1000;
        }
        while (!process.isEmpty()) {
            sb.append(convert(process.removeFirst(), --i));
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static String convert(int num, int idx) {
        final StringBuilder sb = new StringBuilder();
        if (num == 0) {
            return sb.toString();
        }
        if (num >= 100) {
            sb.append(SINGLE[num / 100]);
            sb.append("Hundred ");
            num %= 100;
        }
        if (num <= 19) {
            sb.append(LESS_20[num]);
        } else {
            sb.append(OVER_20[num / 10]);
            sb.append(num % 10 == 0 ? "" : SINGLE[num % 10]);
        }
        sb.append(THOUSAND[idx]);
        return sb.toString();
    }
}
