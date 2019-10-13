import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SubstringConcatenateAllWords {

    public static List<Integer> findSubstring1(String s, String[] words) {
        final int N = s.length();
        final List<Integer> indexes = new ArrayList<>();
        if (words.length == 0) {
            return indexes;
        }
        final int M = words[0].length();
        if (N < M * words.length) {
            return indexes;
        }
        final int last = N - M + 1;

        //map each string in words array to some index and compute target counters
        final Map<String, Integer> mapping = new HashMap<>();
        final int[][] table = new int[2][words.length];
        int failures = 0, index = 0;
        for (String word : words) {
            Integer mapped = mapping.get(word);
            if (mapped == null) {
                ++failures;
                mapping.put(word, index);
                mapped = index++;
            }
            ++table[0][mapped];
        }

        //find all occurrences at string S and map them to their current integer, -1 means no such string is in words array
        final int[] sMapping = new int[last];
        for (int i = 0; i < last; ++i) {
            final String section = s.substring(i, i + M);
            final Integer mapped = mapping.get(section);
            if (mapped == null) {
                sMapping[i] = -1;
            } else {
                sMapping[i] = mapped;
            }
        }

        //fix the number of linear scans
        for (int i = 0; i < M; ++i) {
            //reset scan variables
            int currentFailures = failures; //number of current mismatches
            int left = i, right = i;
            Arrays.fill(table[1], 0);
            //here, simple solve the minimum-window-substring problem
            while (right < last) {
                while (currentFailures > 0 && right < last) {
                    final int target = sMapping[right];
                    if (target != -1 && ++table[1][target] == table[0][target]) {
                        --currentFailures;
                    }
                    right += M;
                }
                while (currentFailures == 0 && left < right) {
                    final int target = sMapping[left];
                    if (target != -1 && --table[1][target] == table[0][target] - 1) {
                        final int length = right - left;
                        //instead of checking every window, we know exactly the length we want
                        if ((length / M) == words.length) {
                            indexes.add(left);
                        }
                        ++currentFailures;
                    }
                    left += M;
                }
            }

        }
        return indexes;
    }

    public static List<Integer> findSubstring2(String s, String[] words) {
        if (words.length == 0) {
            return Collections.emptyList();
        }
        final Map<String, Integer> wordToFreq = new HashMap<>();
        for (String word : words) {
            wordToFreq.merge(word, 1, Integer::sum);
        }
        final int unitSize = words[0].length();
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i + unitSize * words.length <= s.length(); i++) {
            if (matchAllWordsInDict(s, new HashMap<>(wordToFreq), i, words.length, unitSize)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean matchAllWordsInDict(String s,
                                               Map<String, Integer> wordToFreq,
                                               int start,
                                               int numWords,
                                               int unitSize) {
        for (int i = 0; i < numWords; i++) {
            final String currWord = s.substring(start + i * unitSize, start + (i + 1) * unitSize);
            if (!wordToFreq.containsKey(currWord)) {
                return false;
            }
            wordToFreq.compute(currWord, (a, b) -> b == 1 ? null : b - 1);
        }
        return wordToFreq.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(findSubstring1("barfoothefoobarman",
                                          new String[] { "foo", "bar" }));
        System.out.println(findSubstring1("wordgoodgoodgoodbestword",
                                          new String[] { "word", "good", "best", "word" }));
        System.out.println(findSubstring2("barfoothefoobarman",
                                          new String[] { "foo", "bar" }));
        System.out.println(findSubstring2("wordgoodgoodgoodbestword",
                                          new String[] { "word", "good", "best", "word" }));
    }

    private SubstringConcatenateAllWords() {}
}
