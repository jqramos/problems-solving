package com.solve.partOne;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LeetCodeOne {

    public int missingNumber(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i<size; i++) {
            if(nums[i] != i) {
                return i;
            }
        }
        return 1;
    }
}
