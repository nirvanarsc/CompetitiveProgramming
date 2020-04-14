package weekly_contests.weekly_56;

public class P_717 {

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length) {
            if (i == bits.length - 1) {
                return true;
            }
            i += bits[i] == 0 ? 1 : 2;
        }
        return false;
    }
}
