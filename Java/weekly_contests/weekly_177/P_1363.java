package weekly_contests.weekly_177;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_1363 {

    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);
        final List<Integer> rem1List = new ArrayList<>();
        final List<Integer> rem2List = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
            if (digits[i] % 3 == 1 && rem1List.size() < 2) {
                rem1List.add(i);
            } else if (digits[i] % 3 == 2 && rem2List.size() < 2) {
                rem2List.add(i);
            }
        }
        if (sum % 3 == 1) {
            if (rem1List.size() >= 1) { return getResult(digits, rem1List.get(0)); }
            if (rem2List.size() >= 2) { return getResult(digits, rem2List.get(0), rem2List.get(1)); }
            return "";
        }
        if (sum % 3 == 2) {
            if (rem2List.size() >= 1) { return getResult(digits, rem2List.get(0)); }
            if (rem1List.size() >= 2) { return getResult(digits, rem1List.get(0), rem1List.get(1)); }
            return "";
        }
        return getResult(digits, -1);
    }

    private static String getResult(int[] digits, Integer... banned) {
        final Set<Integer> bannedSet = new HashSet<>(Arrays.asList(banned));
        final StringBuilder builder = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            if (!bannedSet.contains(i)) {builder.append(digits[i]);}
        }
        if (builder.length() > 0 && builder.charAt(0) == '0') {
            return "0";
        }
        return builder.toString();
    }
}
