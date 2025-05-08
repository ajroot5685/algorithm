package com.baekjoon.parsing;

import java.io.*;
import java.util.*;

public class _21942_gold_2 {

    static FastReader scan = new FastReader();

    static int[] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static int n;
    static int periodMinute;
    static long fee;

    static Map<String, String> ledger = new HashMap<>();
    static Map<String, Long> result = new TreeMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();

        for (Map.Entry<String, Long> person : result.entrySet()) {
            sb.append(person.getKey()).append(" ").append(person.getValue()).append("\n");
        }
        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }

    static void input() {
        n = scan.nextInt();
        periodMinute = parseToMinute(scan.next());
        fee = scan.nextInt();

        for (int i = 0; i < n; i++) {
            solve(scan.nextLine());
        }
    }

    static int parseToMinute(String s) {
        int day = Integer.parseInt(s.substring(0, 3));
        int hour = Integer.parseInt(s.substring(4, 6));
        int minute = Integer.parseInt(s.substring(7, 9));

        return day * 24 * 60 + hour * 60 + minute;
    }

    static void solve(String input) {
        String[] split = input.split(" ");
        String key = split[2] + "," + split[3];
        String value = split[0].substring(5) + "," + split[1];

        if (ledger.containsKey(key)) {
            int minuteDifference = calculateMinuteDifference(key, value);
            recordFee(split[3], minuteDifference);
        } else {
            ledger.put(key, value);
        }
    }

    static int calculateMinuteDifference(String key, String returnTime) {
        // 01-23,14:04
        String rentalTime = ledger.remove(key);

        int minute = calculateDateToMinute(rentalTime.substring(0, 5), returnTime.substring(0, 5));
        minute += calculateTimeToMinute(rentalTime.substring(6, 11), returnTime.substring(6, 11));
        return minute;
    }

    static int calculateDateToMinute(String rentalDate, String returnDate) {
        // 01-23
        int dayToMinute = 24 * 60;

        int rentalMonth = Integer.parseInt(rentalDate.substring(0, 2));
        int rentalDay = Integer.parseInt(rentalDate.substring(3, 5));

        int returnMonth = Integer.parseInt(returnDate.substring(0, 2));
        int returnDay = Integer.parseInt(returnDate.substring(3, 5));

        int minute = 0;
        for (int i = rentalMonth; i < returnMonth; i++) {
            minute += dayOfMonth[i - 1] * dayToMinute;
        }
        minute -= (rentalDay - 1) * dayToMinute;
        minute += (returnDay - 1) * dayToMinute;

        return minute;
    }

    static int calculateTimeToMinute(String rentalTime, String returnTime) {
        // 14:04
        int hourToMinute = 60;

        int rentalMinute = Integer.parseInt(rentalTime.substring(0, 2)) * hourToMinute +
                Integer.parseInt(rentalTime.substring(3, 5));
        int returnMinute = Integer.parseInt(returnTime.substring(0, 2)) * hourToMinute +
                Integer.parseInt(returnTime.substring(3, 5));

        return returnMinute - rentalMinute;
    }

    static void recordFee(String person, int minuteDifference) {
        if (minuteDifference - periodMinute > 0) {
            result.put(person, result.getOrDefault(person, 0L) + (minuteDifference - periodMinute) * fee);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
