package com.baekjoon.greedy;

import java.io.*;
import java.util.*;

public class _18186_diamond_5 {

    static FastReader scan = new FastReader();

    static int n, b, c;
    static int[] arr;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();

        arr = new int[n + 2];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
    }

    static void solve() {
        long result = 0;
        if (b <= c) {
            for (int i = 0; i < n; i++) {
                result += (long) arr[i] * b;
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (arr[i + 1] > arr[i + 2]) {
                    int amount5 = Math.min(arr[i], arr[i + 1] - arr[i + 2]);
                    arr[i] -= amount5;
                    arr[i + 1] -= amount5;

                    result += (long) amount5 * (b + c);
                }

                int amount7 = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
                arr[i] -= amount7;
                arr[i + 1] -= amount7;
                arr[i + 2] -= amount7;
                result += amount7 * (b + 2L * c);

                int amount3 = arr[i];
                arr[i] -= amount3;
                result += (long) amount3 * b;
            }
        }

        System.out.println(result);
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
