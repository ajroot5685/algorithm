package com.baekjoon.greedy;

import java.io.*;
import java.util.*;

public class _1114_gold_1 {

    static FastReader scan = new FastReader();

    static int l, k, c;
    static int[] arr;

    static int min = Integer.MAX_VALUE;
    static int first = Integer.MAX_VALUE;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        l = scan.nextInt();
        k = scan.nextInt();
        c = scan.nextInt();

        arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = scan.nextInt();
        }
    }

    static void solve() {
        Arrays.sort(arr);

        int left = 1;
        int right = l;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(min + " " + first);
    }

    static boolean check(int maxLength) {
        int maxPiece = -1;
        int before = l;
        int cut = 0;

        for (int i = k - 1; i > 0; i--) {
            if (before - arr[i - 1] > maxLength) {
                maxPiece = Math.max(maxPiece, before - arr[i]);
                before = arr[i];
                if (++cut > c) {
                    return false;
                }
            }
        }

        if (cut == c && before > maxLength) {
            return false;
        } else if (cut < c) {
            if (before - arr[0] > maxLength || arr[0] > maxLength) {
                return false;
            } else {
                maxPiece = Math.max(maxPiece, Math.max(before - arr[0], arr[0]));
                before = arr[0];
            }
        } else {
            maxPiece = Math.max(maxPiece, before);
        }

        if (min > maxPiece) {
            min = maxPiece;
            first = before;
        } else if (min == maxPiece) {
            first = Math.min(first, before);
        }
        return true;
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
