package com.baekjoon.divideAndConquer;

import java.io.*;
import java.util.*;

public class _4779_silver_3 {

    static List<Integer> input = new ArrayList<>();
    static char[] canto;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

    static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (true) {
            try {
                if (!((line = br.readLine()) != null && !line.isEmpty())) {
                    break;
                }
                input.add(Integer.parseInt(line));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (Integer num : input) {
            solve(num);
        }
    }

    static void solve(int n) {
        int size = (int) Math.pow(3, n);
        canto = new char[size];
        Arrays.fill(canto, '-');

        dac(0, size);
        sb.append(canto).append("\n");
    }

    static void dac(int left, int right) {
        int midLeft = (right - left) / 3 + left;
        int midRight = (right - left) / 3 * 2 + left;

        Arrays.fill(canto, midLeft, midRight, ' ');

        if (midRight - midLeft <= 1) {
            return;
        }

        dac(left, midLeft);
        dac(midRight, right);
    }
}
