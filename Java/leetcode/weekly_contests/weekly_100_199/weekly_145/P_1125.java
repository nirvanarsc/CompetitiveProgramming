package leetcode.weekly_contests.weekly_100_199.weekly_145;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1125 {

    List<Integer> sol = new ArrayList<>();

    public int[] smallestSufficientTeamBT(String[] req_skills, List<List<String>> people) {
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

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        final Map<String, Integer> idx = new HashMap<>();
        final int n = req_skills.length;
        for (int i = 0; i < n; i++) {
            idx.put(req_skills[i], i);
        }
        final int[] arr = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            int mask = 0;
            for (String skill : people.get(i)) {
                mask |= 1 << idx.get(skill);
            }
            arr[i] = mask;
        }
        final long bestMask = dfs(0, (1 << n) - 1, 0, arr, new Long[arr.length][1 << n]);
        final int[] res = new int[Long.bitCount(bestMask)];
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if ((bestMask & (1L << j)) != 0) {
                res[i++] = j;
            }
        }
        return res;
    }

    private static long dfs(int skills, int target, int idx, int[] arr, Long[][] dp) {
        if (idx == arr.length) {
            return skills == target ? 0 : Long.MAX_VALUE;
        }
        if (dp[idx][skills] != null) {
            return dp[idx][skills];
        }
        long res = dfs(skills, target, idx + 1, arr, dp);
        long take = dfs(skills | arr[idx], target, idx + 1, arr, dp);
        if (take != Long.MAX_VALUE) {
            take |= 1L << idx;
            if (Long.bitCount(res) > Long.bitCount(take)) {
                res = take;
            }
        }
        return dp[idx][skills] = res;
    }
}
