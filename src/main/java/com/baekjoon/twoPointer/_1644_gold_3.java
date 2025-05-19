package com.baekjoon.twoPointer;

import java.io.*;
import java.util.*;

public class _1644_gold_3 {

    static FastReader scan = new FastReader();

    static int n;

    static int[] arr;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
    }

    static void solve() {
        if (n == 1) {
            System.out.println(0);
            return;
        }

        eratosthenes();

        int left = 0;
        int right = 0;
        int sum = arr[0];

        int count = 0;
        while (right < arr.length) {
            if (sum == n) {
                count++;
            }

            if (sum < n) {
                right++;
                if (right < arr.length) {
                    sum += arr[right];
                }
            } else {
                sum -= arr[left];
                left++;
            }
        }

        System.out.println(count);
    }

    static void eratosthenes() {
        boolean[] isNotPrime = new boolean[n + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                count++;
            }
        }

        arr = new int[count];
        int index = 0;
        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                arr[index++] = i;
            }
        }
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
