package com.baekjoon.unionFind;

import java.io.*;
import java.util.*;

public class _20040_gold_4 {

    static FastReader scan = new FastReader();

    static int n, m;
    static int[] parent;

    static int turn = 0;

    public static void main(String[] args) {
        input();
        System.out.println(turn);
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        parent = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            if (turn != 0) {
                continue;
            }
            if (union(a, b)) {
                turn = i;
            }
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return true;
        }
        if (rootX > rootY) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
        }
        return false;
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
