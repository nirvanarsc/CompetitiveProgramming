package weekly_151;

import java.util.ArrayList;
import java.util.List;

public class P_1169 {

    public List<String> invalidTransactions(String[] transactions) {
        final List<String> ans = new ArrayList<>();
        final int n = transactions.length;
        final String[] name = new String[n];
        final int[] time = new int[n];
        final int[] money = new int[n];
        final String[] city = new String[n];
        final boolean[] add = new boolean[n];
        for (int i = 0; i < n; i++) {
            final String[] items = transactions[i].split(",");
            name[i] = items[0];
            time[i] = Integer.valueOf(items[1]);
            money[i] = Integer.valueOf(items[2]);
            city[i] = items[3];
        }
        for (int i = 0; i < n; i++) {
            if (money[i] > 1000) {
                add[i] = true;
            }
            for (int j = i + 1; j < n; j++) {
                if (name[i].equals(name[j]) && Math.abs(time[i] - time[j]) <= 60 && !city[i].equals(city[j])) {
                    add[i] = true;
                    add[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (add[i]) { ans.add(transactions[i]); }
        }
        return ans;
    }
}
