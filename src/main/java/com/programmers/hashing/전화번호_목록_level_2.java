package com.programmers.hashing;

import java.io.*;
import java.util.*;

public class 전화번호_목록_level_2 {

    public static void main(String[] args) {
        String[] phone_book = {"12", "123", "1235", "567", "88"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        for (String phone : set) {
            for (int i = 1; i < phone.length(); i++) {
                if (set.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solution2(String[] phone_book) {
        // 더 빠르다.
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}
