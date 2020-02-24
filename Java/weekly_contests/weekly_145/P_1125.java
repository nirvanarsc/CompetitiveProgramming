package weekly_contests.weekly_145;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1125 {

    List<Integer> sol = new ArrayList<>();

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        final Map<String, Integer> idx = new HashMap<>();
        int n = 0;
        for (String s : req_skills) {
            idx.put(s, n++);
        }
        final int[] pe = new int[people.size()];
        for (int i = 0; i < pe.length; i++) {
            for (String p : people.get(i)) {
                final int skill = idx.get(p);
                pe[i] |= 1 << skill;
            }
        }
        search(0, pe, new ArrayList<>(), n);
        final int[] ans = new int[sol.size()];
        for (int i = 0; i < sol.size(); i++) {
            ans[i] = sol.get(i);
        }
        return ans;
    }

    public void search(int skills, int[] pe, List<Integer> curr, int n) {
        if (skills == (1 << n) - 1) {
            if (sol.isEmpty() || curr.size() < sol.size()) {
                sol = new ArrayList<>(curr);
            }
            return;
        }
        if (!sol.isEmpty() && curr.size() >= sol.size()) {
            return;
        }
        int zeroBit = 0;
        while (((skills >> zeroBit) & 1) == 1) {
            zeroBit++;
        }
        for (int i = 0; i < pe.length; i++) {
            final int per = pe[i];
            if (((per >> zeroBit) & 1) == 1) {
                curr.add(i);
                search(skills | per, pe, curr, n);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
