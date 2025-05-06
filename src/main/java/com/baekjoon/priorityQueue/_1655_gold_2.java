package com.baekjoon.priorityQueue;

import java.io.*;
import java.util.*;

public class _1655_gold_2 {

    static FastReader scan = new FastReader();

    static int n;
    static PriorityQueue<Integer> pqSmall = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> pqBig = new PriorityQueue<>();
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

    static void solve(int num) {
        if (pqSmall.size() <= pqBig.size()) {
            pqSmall.offer(num);
        } else {
            pqBig.offer(num);
        }

        if (!pqSmall.isEmpty() && !pqBig.isEmpty() && pqSmall.peek() > pqBig.peek()) {
            Integer psn = pqSmall.poll();
            Integer pbn = pqBig.poll();
            pqSmall.offer(pbn);
            pqBig.offer(psn);
        }

        sb.append(pqSmall.peek()).append("\n");
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
