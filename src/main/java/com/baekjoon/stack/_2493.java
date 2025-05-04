package com.baekjoon.stack;

import java.io.*;
import java.util.*;

public class _2493 {

    static FastReader scan = new FastReader();

    static int n;
    static Deque<Top> stack = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
    }

    static void input() {
        n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            solve(i, scan.nextInt());
        }
        System.out.println(sb);
    }

    static void solve(int index, int height) {
        Top top = new Top(index, height);
        while (true) {
            if (stack.isEmpty()) {
                sb.append("0 ");
                stack.push(top);
                break;
            } else if (stack.peek().height > top.height) {
                sb.append(stack.peek().index).append(" ");
                stack.push(top);
                break;
            } else if (stack.peek().height == top.height) {
                sb.append(stack.pop().index).append(" ");
                stack.push(top);
                break;
            } else {
                stack.pop();
            }
        }
    }

    static class Top {
        int index;
        int height;

        Top(int index, int height) {
            this.index = index;
            this.height = height;
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
