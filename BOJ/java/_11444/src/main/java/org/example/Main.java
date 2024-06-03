package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        input();
        solve();
    }

    static long n;
    static Map<Long, Long> memo;
    static final long DIVIDE = 1_000_000_007;

    static void solve() {
        memo = new HashMap<>();

        memo.put(1L, 1L);
        memo.put(2L, 1L);

        System.out.println(fibo(n));
    }

    static long fibo(long m) {
        if (memo.containsKey(m)) {
            return memo.get(m);
        }

        long a;
        long b;

        if (m % 2 == 0) {
            a = fibo(m / 2 + 1) * fibo(m / 2);
            b = fibo(m / 2) * fibo(m / 2 - 1);
        } else {
            a = fibo(m / 2 + 1) * fibo(m / 2 + 1);
            b = fibo(m / 2) * fibo(m / 2);
        }

        long result = (a % DIVIDE + b % DIVIDE) % DIVIDE;
        memo.put(m, result);

        return result;
    }

    static void input() {
        n = scan.nextLong();
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}