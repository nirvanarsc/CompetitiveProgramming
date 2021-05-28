package binarysearch.weekly_37;

public class P_2 {

    public boolean solve(int[] cores, int[] tasks) {
        if (cores.length == 0) {
            return tasks.length == 0;
        }
        return dfs(cores, tasks, 0, 0);
    }

    public boolean dfs(int[] cores, int[] tasks, int i, int j) {
        if (cores[j] < 0) {
            return false;
        }
        if (i == tasks.length) {
            return true;
        }
        for (int k = 0; k < cores.length; k++) {
            cores[k] -= tasks[i];
            if (dfs(cores, tasks, i + 1, k)) {
                return true;
            }
            cores[k] += tasks[i];
        }
        return false;
    }
}
