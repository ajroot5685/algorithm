package com.programmers.hashing;

import java.util.HashMap;

public class 완주하지_못한_선수_level_1 {

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String person : participant) {
            map.put(person, map.getOrDefault(person, 0) + 1);
        }
        for (String person : completion) {
            Integer count = map.get(person);
            if (count == null) {
                continue;
            }

            if (count == 1) {
                map.remove(person);
            } else {
                map.put(person, count - 1);
            }
        }

        Object[] array = map.keySet().toArray();
        return (String) array[0];
    }
}
