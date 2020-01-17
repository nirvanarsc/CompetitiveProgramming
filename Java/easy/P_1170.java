package easy;

import java.util.Arrays;

public class P_1170 {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        final int[] res = new int[queries.length];
        final int[] wordMap = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordMap[i] = f(words[i]);
        }
        Arrays.sort(wordMap);
        for (int i = 0; i < queries.length; i++) {
            final int frequency = f(queries[i]);
            if (wordMap[words.length - 1] <= frequency) {
                res[i] = 0;
            } else {
                res[i] = words.length - binarySearch(wordMap, frequency);
            }
        }
        return res;
    }

    private static int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (arr[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int f(String word) {
        final int[] freq = new int[26];
        char minChar = 'z';
        for (char c : word.toCharArray()) {
            if (c <= minChar) {
                freq[c - 'a']++;
                minChar = c;
            }
        }
        return freq[minChar - 'a'];
    }

    public int[] numSmallerByFrequencyCountingSort(String[] queries, String[] words) {
        final int[] wordScores = new int[words.length];
        final int[] scoreMap = new int[11];
        final int[] prefixSumScore = new int[11];
        final int[] res = new int[queries.length];
        for (int i = 0; i < words.length; i++) {
            wordScores[i] = f(words[i]);
            scoreMap[wordScores[i]]++;
        }
        prefixSumScore[0] = scoreMap[0];
        for (int i = 1; i < scoreMap.length; i++) {
            prefixSumScore[i] = prefixSumScore[i - 1] + scoreMap[i];
        }
        for (int i = 0; i < queries.length; i++) {
            final String query = queries[i];
            final int score = f(query);
            res[i] = words.length - prefixSumScore[score];
        }
        return res;
    }
}
