package com.pratice.leetcode.greedy;

import java.util.Arrays;

public class Leetcode_1710_maximum_units_on_a_truck_02 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (int[] a, int[] b) -> b[1] - a[1]);
        int tmpTruckSize = truckSize;
        int ans = 0;

        for (int i = 0; i < boxTypes.length; i++) {
            if (tmpTruckSize > 0) {
                int[] maxBox = boxTypes[i];
                int boxCount = Math.min(tmpTruckSize, maxBox[0]);
                ans += maxBox[1] * boxCount;
                tmpTruckSize -= boxCount;
            }
        }
        return ans;
    }
}
