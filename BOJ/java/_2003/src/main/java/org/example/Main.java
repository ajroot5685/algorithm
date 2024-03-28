package org.example;


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] arr;
    static int result=0;

    public static void main(String[] args) {
        input();
        solve();
        System.out.println(result);
    }
    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();

        arr = new int[n];

        for (int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }
    }
    static void solve(){
        int start = 0;
        int end = 0;
        int sum = 0;

        while(start<n){
            if (sum>=m){
                sum-=arr[start++];
            }else if (end >= n){
                break;
            }else {
                sum+=arr[end++];
            }

            if (sum==m){
                result++;
            }
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}