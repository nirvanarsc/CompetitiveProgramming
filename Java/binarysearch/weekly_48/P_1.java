package binarysearch.weekly_48;

public class P_1 {

    public int solve(int[] rooms, int target) {
        for (int room : rooms) {
            if (room >= target) {
                return room;
            }
        }
        return -1;
    }
}
