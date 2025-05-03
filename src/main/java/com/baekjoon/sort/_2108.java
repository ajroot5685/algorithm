package com.baekjoon.sort;

import java.io.*;
import java.util.*;

public class _2108 {

    static FastReader scan = new FastReader();

    static int n;
    static List<Integer> arr = new ArrayList<>();
    static Map<Integer, Integer> freq = new HashMap<>();

    static int sum;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int nextInt = scan.nextInt();
            arr.add(nextInt);
            sum += nextInt;
            freq.put(nextInt, freq.getOrDefault(nextInt, 0) + 1);
        }
    }

    static void solve() {
        Collections.sort(arr);

        // 1. 산술평균
        System.out.println((int) Math.round((double) sum / n));

        // 2. 중앙값
        System.out.println(arr.get(n / 2));

        // 3. 최빈값
        int maxFreq = Collections.max(freq.values());
        List<Integer> maxFreqList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == maxFreq) {
                maxFreqList.add(entry.getKey());
            }
        }
        Collections.sort(maxFreqList);
        int freqResult = maxFreqList.size() == 1 ? maxFreqList.get(0) : maxFreqList.get(1);
        System.out.println(freqResult);

        // 4. 범위
        System.out.println(arr.get(n - 1) - arr.get(0));

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
