package weekly_contests.weekly_65;

public class P_755 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int[] pourWater(int[] heights, int V, int K) {
        while (V-- > 0) {
            int curr = K;
            while (curr > 0 && heights[curr] >= heights[curr - 1]) {
                curr--;
            }
            while (curr < heights.length - 1 && heights[curr] >= heights[curr + 1]) {
                curr++;
            }
            while (curr > K && heights[curr] == heights[curr - 1]) {
                curr--;
            }
            heights[curr]++;
        }
        return heights;
    }
}
