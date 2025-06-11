package com.baekjoon.prefixSum;

import java.io.*;
import java.util.*;

public class _2143_gold_3 {

    static FastReader scan = new FastReader();

    static int t, n, m;
    static int[] a;
    static int[] b;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        t = scan.nextInt();

        n = scan.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }

        m = scan.nextInt();
        b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scan.nextInt();
        }
    }

    static void solve() {
        long result = 0;

        List<Integer> subSumA = getSubSum(a);
        List<Integer> subSumB = getSubSum(b);

        int left = 0;
        int right = subSumB.size() - 1;

        while (left < subSumA.size() && right >= 0) {
            int sum = subSumA.get(left) + subSumB.get(right);

            if (sum < t) {
                left++;
            } else if (sum > t) {
                right--;
            } else {
                int tmpA = subSumA.get(left);
                int numA = 0;
                while (left < subSumA.size() && subSumA.get(left) == tmpA) {
                    numA++;
                    left++;
                }

                int tmpB = subSumB.get(right);
                int numB = 0;
                while (right >= 0 && subSumB.get(right) == tmpB) {
                    numB++;
                    right--;
                }

                result += (long) numA * numB;
            }
        }

        System.out.println(result);
    }

    static List<Integer> getSubSum(int[] arr) {
        List<Integer> subSum = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                subSum.add(sum);
            }
        }

        Collections.sort(subSum);
        return subSum;
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
