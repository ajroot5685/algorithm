package com.programmers.hashing;

import java.io.*;
import java.util.*;

public class 의상_level_2 {

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        int result = 1;
        for (Integer value : map.values()) {
            result *= (value + 1); // 가짓수
        }

        return result - 1; // 아무것도 안입은 경우 제외
    }
}
