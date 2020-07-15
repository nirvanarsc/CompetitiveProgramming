package weekly_contests.weekly_136;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({ "MethodParameterNamingConvention", "TailRecursion" })
public class P_1044 {

    /**
     * Note: this class has a natural ordering that is inconsistent with equals.
     */
    public static class Suffix implements Comparable<Suffix> {
        int index;
        int[] rank = new int[2];

        @Override
        public int compareTo(Suffix other) {
            return rank[0] == other.rank[0] ? Integer.compare(rank[1], other.rank[1])
                                            : Integer.compare(rank[0], other.rank[0]);
        }
    }

    private static int[] buildSuffixArray(String s, int n) {
        final Suffix[] sa = new Suffix[n];
        for (int i = 0; i < n; i++) {
            sa[i] = new Suffix();
            sa[i].index = i;
            sa[i].rank[0] = s.charAt(i) - 'a';
            sa[i].rank[1] = i < n - 1 ? s.charAt(i + 1) - 'a' : -1;
        }
        Arrays.sort(sa);
        final int[] ind = new int[n];
        for (int k = 4; k < 2 * n; k *= 2) {
            int rank = 0;
            int prev_rank = sa[0].rank[0];
            ind[sa[0].index] = 0;
            for (int i = 1; i < n; i++) {
                if (sa[i].rank[0] == prev_rank && sa[i].rank[1] == sa[i - 1].rank[1]) {
                    prev_rank = sa[i].rank[0];
                    sa[i].rank[0] = rank;
                } else {
                    prev_rank = sa[i].rank[0];
                    sa[i].rank[0] = ++rank;
                }
                ind[sa[i].index] = i;
            }
            for (int i = 0; i < n; i++) {
                final int nextindex = sa[i].index + k / 2;
                sa[i].rank[1] = (nextindex < n) ? sa[ind[nextindex]].rank[0] : -1;
            }
            Arrays.sort(sa);
        }
        final int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = sa[i].index;
        }
        return ret;
    }

    static int[] kasai(String s, int[] suffixArr) {
        final int n = suffixArr.length;
        final int[] lcp = new int[n];
        final int[] invSuff = new int[n];
        for (int i = 0; i < n; i++) {
            invSuff[suffixArr[i]] = i;
        }
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (invSuff[i] == n - 1) {
                k = 0;
                continue;
            }
            final int j = suffixArr[invSuff[i] + 1];
            while (i + k < n && j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            }
            lcp[invSuff[i]] = k;
            if (k > 0) { k--; }
        }
        return lcp;
    }

    public String longestDupSubstring(String S) {
        final int[] suffixArr = buildSuffixArray(S, S.length());
        final int[] lcp = kasai(S, suffixArr);

        int ans = 0;
        int start = 0;

        for (int i = 0; i < S.length(); i++) {
            if (lcp[i] > ans) {
                ans = lcp[i];
                start = suffixArr[i];
            }
        }
        return ans == 0 ? "" : S.substring(start, start + ans);
    }

    public String longestDupSubstringTrie(String S) {
        class Trie {
            Trie[] children;
            final int startPos;
            final int depth;

            Trie(int startPos, int depth) {
                this.startPos = startPos;
                this.depth = depth;
            }

            boolean isLeaf() {
                return children == null;
            }

            int childIndex(int start) {
                return S.charAt(start + depth) - 'a';
            }

            int addNew(int start) {
                if (start + depth == S.length()) {
                    return depth;
                }
                if (isLeaf()) {
                    children = new Trie[26];
                    children[childIndex(startPos)] = new Trie(startPos, depth + 1);
                }
                final int newIndex = childIndex(start);
                final Trie child = children[newIndex];
                if (child == null) {
                    children[newIndex] = new Trie(start, depth + 1);
                    return depth;
                }
                return child.addNew(start);
            }
        }
        int maxStart = 0, maxLength = 0;
        final int length = S.length();
        final Trie root = new Trie(0, 0);
        for (int i = 1; i + maxLength < length; i++) {
            final int len = root.addNew(i);
            if (len > maxLength) {
                maxStart = i;
                maxLength = len;
            }
        }
        return S.substring(maxStart, maxStart + maxLength);
    }

    private static final long MOD = 792606555396977L;
    private static final int SIZE = 26;

    public static int search(int mid, long[] diff, int[] nums, String S) {
        final Set<Long> seen = new HashSet<>();
        long hash = 0;
        for (int i = 0; i < nums.length; i++) {
            hash = (hash * SIZE + nums[i]) % MOD;
            if (i >= mid) {
                hash = Math.floorMod(hash - Math.floorMod(nums[i - mid] * diff[mid], MOD), MOD);
            }
            if (i >= mid - 1 && !seen.add(hash)) {
                return i;
            }
        }
        return -1;
    }

    public String longestDupSubstringRabinKarp(String S) {
        final int n = S.length();
        final int[] nums = new int[n];
        final long[] diff = new long[n];
        for (int i = 0; i < n; ++i) {
            diff[i] = i == 0 ? 1 : (diff[i - 1] * SIZE) % MOD;
            nums[i] = S.charAt(i) - 'a';
        }
        int lo = 0, hi = n, finalEnd = -1;
        while (lo < hi) {
            final int mid = (1 + lo + hi) >>> 1;
            final int end = search(mid, diff, nums, S);
            if (end != -1) {
                finalEnd = end;
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return S.substring(finalEnd - lo + 1, finalEnd + 1);
    }
}
