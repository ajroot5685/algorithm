package com.baekjoon.slidingWindow;

import java.io.*;
import java.util.*;

public class _12891_silver_2 {

    static FastReader scan = new FastReader();

    static int s, p;
    static char[] arr;
    static int[] minAmount;
    static int[] count;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        s = scan.nextInt();
        p = scan.nextInt();

        arr = scan.next().toCharArray();

        minAmount = new int[4];
        for (int i = 0; i < 4; i++) {
            minAmount[i] = scan.nextInt();
        }
    }

    static void solve() {
        int result = 0;

        count = new int[4];
        for (int i = 0; i < p; i++) {
            plus(arr[i]);

            if (i == p - 1 && check()) {
                result++;
            }
        }

        for (int i = p; i < s; i++) {
            plus(arr[i]);
            minus(arr[i - p]);
            if (check()) {
                result++;
            }
        }

        System.out.println(result);
    }

    static void plus(char c) {
        if (c == 'A') {
            count[0]++;
        } else if (c == 'C') {
            count[1]++;
        } else if (c == 'G') {
            count[2]++;
        } else if (c == 'T') {
            count[3]++;
        }
    }

    static void minus(char c) {
        if (c == 'A') {
            count[0]--;
        } else if (c == 'C') {
            count[1]--;
        } else if (c == 'G') {
            count[2]--;
        } else if (c == 'T') {
            count[3]--;
        }
    }

    static boolean check() {
        for (int i = 0; i < 4; i++) {
            if (count[i] < minAmount[i]) {
                return false;
            }
        }
        return true;
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
