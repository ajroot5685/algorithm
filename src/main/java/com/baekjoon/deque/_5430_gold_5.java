package com.baekjoon.deque;

import java.io.*;
import java.util.*;

public class _5430_gold_5 {

    static FastReader scan = new FastReader();

    static int t;
    static String p;
    static Deque<Integer> arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            p = scan.next();
            arr = new ArrayDeque<>();
            int length = scan.nextInt();
            String inputArr = scan.next();
            String[] split = inputArr.replace("[", "").replace("]", "").split(",");
            for (int j = 0; j < length; j++) {
                arr.offerLast(Integer.parseInt(split[j]));
            }
            solve();
        }
    }

    static void solve() {
        boolean orderForward = true;
        for (char c : p.toCharArray()) {
            if (c == 'R') {
                orderForward = !orderForward;
            } else {
                if (arr.isEmpty()) {
                    sb.append("error\n");
                    return;
                } else if (orderForward) {
                    arr.pollFirst();
                } else {
                    arr.pollLast();
                }
            }
        }

        if (arr.isEmpty()) {
            sb.append("[]\n");
        } else if (orderForward) {
            sb.append("[").append(arr.pollFirst());
            while (!arr.isEmpty()) {
                sb.append(",").append(arr.pollFirst());
            }
            sb.append("]\n");
        } else {
            sb.append("[").append(arr.pollLast());
            while (!arr.isEmpty()) {
                sb.append(",").append(arr.pollLast());
            }
            sb.append("]\n");
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
