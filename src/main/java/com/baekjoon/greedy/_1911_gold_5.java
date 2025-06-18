package com.baekjoon.greedy;

import java.io.*;
import java.util.*;

public class _1911_gold_5 {

    static FastReader scan = new FastReader();

    static int n, l;
    static List<Node> pool;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        l = scan.nextInt();

        pool = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pool.add(new Node(scan.nextInt(), scan.nextInt()));
        }
    }

    static void solve() {
        pool.sort(Comparator.comparingInt(o -> o.start));

        int count = 0;
        int last = -1;

        for (Node node : pool) {
            if (node.start - 1 > last) {
                last = node.start - 1;
            }
            while (node.end - 1 > last) {
                count++;
                last += l;
            }
        }

        System.out.println(count);
    }

    static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
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
