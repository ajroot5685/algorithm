package com.swea.d4;

import java.io.*;
import java.util.*;

public class _3752 {

    static FastReader scan = new FastReader();

    static int t;
    static int n;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        t = scan.nextInt();

        for (int i = 1; i <= t; i++) {
            n = scan.nextInt();
            arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = scan.nextInt();
            }

            sb.append("#").append(i).append(" ");
            solve();
        }
    }

    static void solve() {
        Arrays.sort(arr);

        boolean[] dp = new boolean[10100];
        int result = 1;

        int maxIndex = -1;
        for (int num : arr) {
            for (int i = maxIndex; i >= 0; i--) {
                if (dp[i] && !dp[i + num]) {
                    dp[i + num] = true;
                    result++;
                    maxIndex = Math.max(maxIndex, i + num);
                }
            }
            if (!dp[num]) {
                dp[num] = true;
                result++;
                maxIndex = Math.max(maxIndex, num);
            }
        }

        sb.append(result).append("\n");
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
