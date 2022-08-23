package leetcode.weekly_contests.weekly_300_399.weekly_307;

public class P_1 {

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        final int n = energy.length;
        int s = 0;
        int e = 0;
        int ce = initialExperience;
        for (int i = 0; i < n; i++) {
            s += energy[i];
            e = Math.max(e, Math.max(0, experience[i] - ce + 1));
            ce += experience[i];
        }
        return e + Math.max(0, s - initialEnergy + 1);
    }
}
