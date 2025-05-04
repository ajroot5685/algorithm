package com.baekjoon.stack;

import java.io.*;
import java.util.*;

public class _4949 {

    static FastReader scan = new FastReader();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        while (true) {
            String sentence = scan.nextLine();
            if (sentence.equals(".")) {
                break;
            }

            solve(sentence);
        }
    }

    static void solve(String sentence) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : sentence.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                Character target = stack.pollFirst();
                if (target == null || !target.equals('(')) {
                    sb.append("no").append("\n");
                    return;
                }
            } else if (c == ']') {
                Character target = stack.pollFirst();
                if (target == null || !target.equals('[')) {
                    sb.append("no").append("\n");
                    return;
                }
            }
        }

        if (stack.isEmpty()) {
            sb.append("yes").append("\n");
        } else {
            sb.append("no").append("\n");
        }
    }

    static class FastReader {
        BufferedReader br;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
