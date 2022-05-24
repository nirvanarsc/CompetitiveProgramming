package leetcode.weekly_contests.weekly_100_199.weekly_189;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P_1452 {

    public List<Integer> peopleIndexesBF(List<List<String>> favoriteCompanies) {
        final List<Set<String>> collect = favoriteCompanies.stream()
                                                           .map(HashSet::new)
                                                           .collect(Collectors.toList());
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < collect.size(); i++) {
            boolean add = true;
            for (int j = 0; j < collect.size(); j++) {
                if (i != j && collect.get(j).containsAll(collect.get(i))) {
                    add = false;
                }
            }
            if (add) {
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        for (List<String> list : favoriteCompanies) {
            Collections.sort(list);
        }
        final int n = favoriteCompanies.size();
        final boolean[] covered = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && covered(favoriteCompanies.get(i), favoriteCompanies.get(j))) {
                    covered[i] = true;
                    break;
                }
            }
        }
        final List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < covered.length; i++) {
            if (!covered[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    private static boolean covered(List<String> a, List<String> b) {
        if (a.size() > b.size()) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < a.size() && j < b.size()) {
            final int cmp = a.get(i).compareTo(b.get(j));
            if (cmp == 0) {
                i++;
            } else if (cmp < 0) {
                return false;
            } else {
                j++;
            }
        }
        return i == a.size();
    }
}
