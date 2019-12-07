public final class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int currGas = 0, minCity = 0, minGallons = 0;
        for (int i = 0; i < gas.length; i++) {
            currGas += gas[i] - cost[i];
            if (currGas < minGallons) {
                minCity = i + 1;
                minGallons = currGas;
            }
        }

        return currGas < 0 ? -1 : minCity;
    }

    private GasStation() {}
}
