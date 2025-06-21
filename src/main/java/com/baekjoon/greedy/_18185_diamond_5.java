package com.baekjoon.greedy;

import java.io.*;
import java.util.*;

public class _18185_diamond_5 {

    static FastReader scan = new FastReader();

    static int n;
    static int[] arr;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
    }

    static void solve() {
        long result = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0) {
                continue;
            }
            int amount3 = 0;
            int amount5 = 0;
            int amount7 = 0;
            if (i + 1 < n) {
                if (i + 2 < n) {
                    if (arr[i + 1] > arr[i + 2]) {
                        if (arr[i] > arr[i + 1]) {
                            amount5 = arr[i + 1] - arr[i + 2];
                            calculate5(arr, i, amount5);

                            amount7 = arr[i + 1];
                            calculate7(arr, i, amount7);

                            amount3 = arr[i];
                            calculate3(arr, i, amount3);
                        } else {
                            amount5 = Math.min(arr[i], arr[i + 1] - arr[i + 2]);
                            calculate5(arr, i, amount5);

                            amount7 = arr[i];
                            calculate7(arr, i, amount7);

                            amount3 = arr[i + 1] - arr[i + 2];
                            calculate3(arr, i + 1, amount3);
                        }
                    } else {
                        if (arr[i] > arr[i + 1]) {
                            amount7 = arr[i + 1];
                            calculate7(arr, i, amount7);

                            amount3 = arr[i];
                            calculate3(arr, i, amount3);
                        } else {
                            amount7 = arr[i];
                            calculate7(arr, i, amount7);
                        }
                    }
                } else {
                    amount5 = Math.min(arr[i], arr[i + 1]);
                    calculate5(arr, i, amount5);

                    amount3 = arr[i];
                    calculate3(arr, i, amount3);
                }
            } else {
                amount3 = arr[i];
                calculate3(arr, i, amount3);
            }

            result += amount3 * 3L + amount5 * 5L + amount7 * 7L;
        }

        System.out.println(result);
    }

    static void calculate3(int[] arr, int i, int amount) {
        if (amount == 0) {
            return;
        }
        arr[i] -= amount;
    }

    static void calculate5(int[] arr, int i, int amount) {
        if (amount == 0) {
            return;
        }
        arr[i] -= amount;
        arr[i + 1] -= amount;
    }

    static void calculate7(int[] arr, int i, int amount) {
        if (amount == 0) {
            return;
        }
        arr[i] -= amount;
        arr[i + 1] -= amount;
        arr[i + 2] -= amount;
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
