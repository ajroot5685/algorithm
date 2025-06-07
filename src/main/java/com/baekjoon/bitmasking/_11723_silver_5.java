package com.baekjoon.bitmasking;

import java.io.*;
import java.util.*;

public class _11723_silver_5 {

    static FastReader scan = new FastReader();

    static int m;
    static int s;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        m = scan.nextInt();
        for (int i = 0; i < m; i++) {
            String op = scan.next();
            if (op.equals("add")) {
                add(scan.nextInt());
            } else if (op.equals("remove")) {
                remove(scan.nextInt());
            } else if (op.equals("check")) {
                check(scan.nextInt());
            } else if (op.equals("toggle")) {
                toggle(scan.nextInt());
            } else if (op.equals("all")) {
                all();
            } else if (op.equals("empty")) {
                empty();
            }
        }
    }

    static void add(int i) {
        s |= (1 << i);
    }

    static void remove(int i) {
        s &= ~(1 << i);
    }

    static void check(int i) {
        sb.append((s & (1 << i)) != 0 ? 1 : 0).append("\n");
    }

    static void toggle(int i) {
        s ^= (1 << i);
    }

    static void all() {
        s = (1 << 21) - 1;
    }

    static void empty() {
        s = 0;
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
