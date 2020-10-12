package leetcode.weekly_contests.weekly_57;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.DataStructures.UnionFind;

public class P_721 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        final int n = accounts.size();
        final UnionFind uf = new UnionFind(n);
        final Map<String, Integer> mailToIndex = new HashMap<>();
        final Map<Integer, Set<String>> disjointSet = new HashMap<>();
        final List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                final String currMail = accounts.get(i).get(j);
                if (mailToIndex.containsKey(currMail)) {
                    uf.union(mailToIndex.get(currMail), i);
                } else {
                    mailToIndex.put(currMail, i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            final int parentIndex = uf.find(i);
            final Set<String> curr = disjointSet.getOrDefault(parentIndex, new HashSet<>());
            for (int j = 1; j < accounts.get(i).size(); j++) {
                curr.add(accounts.get(i).get(j));
            }
            disjointSet.put(parentIndex, curr);
        }

        for (Map.Entry<Integer, Set<String>> entry : disjointSet.entrySet()) {
            final List<String> curList = new ArrayList<>(entry.getValue());
            Collections.sort(curList);
            curList.add(0, accounts.get(entry.getKey()).get(0));
            res.add(curList);
        }
        return res;
    }
}
