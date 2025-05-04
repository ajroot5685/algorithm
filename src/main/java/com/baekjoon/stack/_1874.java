package com.baekjoon.stack;

import java.io.*;
import java.util.*;

public class _1874 {

    static FastReader scan = new FastReader();

    static int n;
    static List<Integer> targets = new ArrayList<>();

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            targets.add(scan.nextInt());
        }
    }

    static void solve() {
        int now = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (Integer target : targets) {
            if (stack.isEmpty()) {
                stack.push(now++);
                sb.append("+\n");
            }
            while (true) {
                Integer top = stack.peek();
                if (top > target) {
                    System.out.println("NO");
                    return;
                } else if (top < target) {
                    stack.push(now++);
                    sb.append("+\n");
                } else {
                    stack.pop();
                    sb.append("-\n");
                    break;
                }
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("NO");
            return;
        }
        System.out.println(sb);
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
