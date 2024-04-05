package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;

    static int[] set;

    public static void main(String[] args) {
        input();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        set = new int[n+1];

        for (int i = 0; i < n + 1; i++) {
            set[i] = i;
        }

        for (int i = 0; i < m; i++) {
            solve(scan.nextLine());
        }
    }

    static void solve(String s) {
        StringTokenizer sst = new StringTokenizer(s);

        int menu = Integer.parseInt(sst.nextToken());
        int a = Integer.parseInt(sst.nextToken());
        int b = Integer.parseInt(sst.nextToken());

        if (menu == 0) {
            union(a, b);
        } else {
            if (find(a) == find(b)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    static int find(int x) {
        if (set[x] == x) {
            return x;
        } else {
            return find(set[x]);
        }
    }

    static void union(int x, int y) {
        int parentx = find(x);
        int parenty = find(y);

        if (parentx > parenty) {
            set[parenty] = parentx;
        } else {
            set[parentx] = parenty;
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}