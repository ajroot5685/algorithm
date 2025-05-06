package com.baekjoon.priorityQueue;

import java.io.*;
import java.util.*;

public class _11279_silver_2 {

    static FastReader scan = new FastReader();

    static int n;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            solve(scan.nextInt());
        }
    }

    static void solve(int op) {
        if (op == 0) {
            Integer poll = pq.poll();
            sb.append(poll == null ? 0 : poll).append("\n");
        } else {
            pq.offer(op);
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
