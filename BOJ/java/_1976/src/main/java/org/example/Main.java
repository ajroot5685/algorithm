package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static int n;
    static int m;
    static int[] set;

    public static void main(String[] args) {
        input();
    }

    static void input() {
        n = scan.nextInt();

        set = new int[n+1];

        for (int i = 0; i <= n; i++) {
            set[i] = i;
        }

        m = scan.nextInt();

        for (int i = 1; i <= n; i++) {
            cityInput(i);
        }

        solve();
    }

    static void solve() {
        int tmp = find(scan.nextInt());
        for (int i = 1; i < m; i++) {
            int tmp2 = scan.nextInt();
            if (tmp != find(tmp2)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    static void cityInput(int i) {
        for (int j = 1; j <= n; j++) {
            int connect = scan.nextInt();

            if (connect == 1) {
                union(i, j);
            }
        }
    }

    static int find(int x) {
        if (set[x] == x) {
            return x;
        }
        return set[x] = find(set[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x > y) {
            set[y] = x;
        } else {
            set[x] = y;
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