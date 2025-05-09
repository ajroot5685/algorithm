package com.baekjoon.string;

import java.io.*;
import java.util.*;

public class _9935_gold_4 {

    static FastReader scan = new FastReader();

    static String s;
    static String bomb;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        s = scan.next();
        bomb = scan.next();
    }

    static void solve() {
        List<Character> stack = new ArrayList<>();

        for (char c : s.toCharArray()) {
            stack.add(c);

            if (stack.size() >= bomb.length()) {
                boolean flag = true;
                for (int i = 0; i < bomb.length(); i++) {
                    if (stack.get(stack.size() - bomb.length() + i) != bomb.charAt(i)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int i = 0; i < bomb.length(); i++) {
                        stack.remove(stack.size() - 1);
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            System.out.println(sb);
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
