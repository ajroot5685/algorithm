package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;

    static int[] output;
    static int[] num;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = scan.nextInt();
        }
    }

    static void solve() {
        Arrays.sort(num);

        output = new int[m];

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (prev == num[i]) {
                continue;
            }
            if (depth >= 1 && output[depth - 1] > num[i]) {
                continue;
            }
            output[depth] = num[i];

            dfs(depth + 1);

            prev = num[i];
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