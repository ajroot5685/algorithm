package com.programmers.hashing;

import java.io.*;
import java.util.*;

public class 폰켓몬_level_1 {

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 2};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return Math.min((nums.length / 2), map.size());
    }
}
