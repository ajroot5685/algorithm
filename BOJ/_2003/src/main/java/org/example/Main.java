package org.example;


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] arr;
    static int incase=0;

    public static void main(String[] args) {
        input();
        solve();
        System.out.println(incase);
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

        while(true){
            if (end>=n){
                break;
            }

            int sum = sum(start, end);

            if (sum==m){
                incase++;
                end++;
            }else if (sum>m){
                start++;
            }else{
                end++;
            }
        }
    }
    static int sum(int s, int e){
        int result = 0;
        for (int i=s;i<=e;i++){
            result+=arr[i];
        }

        return result;
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