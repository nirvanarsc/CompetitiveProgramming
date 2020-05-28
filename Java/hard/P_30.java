package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_30 {

    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (nums[mid] > nums[0]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        hi = nums.length + lo;
        System.out.println(lo);
        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (nums[mid % nums.length] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo % nums.length] == target ? lo % nums.length : -1;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) {
            return Collections.emptyList();
        }
        final List<Integer> res = new ArrayList<>();
        final Map<String, Integer> wordsFreq = new HashMap<>();
        for (String str : words) {
            wordsFreq.merge(str, 1, Integer::sum);
        }
        final int wordLength = words[0].length();
        for (int start = 0; start < wordLength; start++) {
            final Map<String, Integer> currOffset = new HashMap<>(wordsFreq);
            int matched = words.length;
            int j = start;
            for (int i = start; i <= s.length() - wordLength; i += wordLength) {
                if (currOffset.merge(s.substring(i, i + wordLength), -1, Integer::sum) >= 0) {
                    matched--;
                }
                while (matched == 0) {
                    if (i - j + wordLength == words.length * wordLength) {
                        res.add(j);
                    }
                    if (currOffset.merge(s.substring(j, j + wordLength), 1, Integer::sum) == 1) {
                        matched++;
                    }
                    j += wordLength;
                }
            }
        }
        return res;
    }
}
