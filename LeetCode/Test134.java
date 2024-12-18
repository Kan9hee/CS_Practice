package LeetCode;

public class Test134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int gasTank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            gasTank += gas[i] - cost[i];
            if (gasTank < 0) {
                start = i + 1;
                gasTank = 0;
            }
        }

        // 어느 곳도 시작지점이 될 수 없거나
        // 총합 소요 가스량에 비해 총합 보급 가스량이 모자랄 경우
        if (start == gas.length || totalGas < totalCost)
            return -1;

        return start;
    }
}