package org.example;

import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static long a;
    static long b;
    static long c;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        a = scan.nextLong();
        b = scan.nextLong();
        c = scan.nextLong();
    }

    static long result;
    static void solve() {
        a = a % c;

        result = divide(b);

        System.out.println(result);
    }

    static long divide(long b) {
        if (b == 1) {
            return a;
        }

        long tmp = divide(b / 2);

        if (b % 2 == 1) {
            return (tmp * tmp % c) * divide(1) % c;
        } else {
            return tmp * tmp % c;
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}