package weekly_contests.weekly_1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P_386 {

    List<Integer> res = new ArrayList<>();
    int n;

    public List<Integer> lexicalOrder(int n) {
        this.n = n;
        for (int i = 1; i <= 9; i++) {
            dfs(i);
        }
        return res;
    }

    private void dfs(int curr) {
        if (curr > n) {
            return;
        }
        res.add(curr);
        for (int i = 0; i <= 9 && 10 * curr + i <= n; i++) {
            dfs(10 * curr + i);
        }
    }

    public List<Integer> lexicalOrderStream(int n) {
        return IntStream.rangeClosed(1, n)
                        .mapToObj(String::valueOf)
                        .sorted()
                        .map(Integer::valueOf)
                        .collect(Collectors.toList());
    }
}
