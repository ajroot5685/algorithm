package com.baekjoon.unionFind;

import java.io.*;
import java.util.*;

public class _24542_silver_1 {

    static FastReader scan = new FastReader();

    static int n, m;
    static int[] parent;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            union(a, b);
        }
    }

    static void solve() {
        int[] count = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            count[find(i)]++;
        }

        long result = 1;
        for (int i = 1; i < n + 1; i++) {
            if (count[i] != 0) {
                result = (result * count[i]) % 1_000_000_007;
            }
        }

        System.out.println(result);
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootY > rootX) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
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
