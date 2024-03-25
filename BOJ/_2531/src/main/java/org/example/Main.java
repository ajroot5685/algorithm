package org.example;


import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    static StringBuilder sb = new StringBuilder();

    static int n, d, k, c;
    static int[] arr;
    static int result = 0;
    static int[] type;

    public static void main(String[] args) {
        input();
        solve();
        System.out.println(result);
    }
    static void input(){
        n = scan.nextInt();
        d = scan.nextInt();
        k = scan.nextInt();
        c = scan.nextInt();

        arr = new int[n];
        type = new int[d+1];

        for (int i=0;i<n;i++){
            int tmp = scan.nextInt();
            arr[i] = tmp;
        }
    }
    static int now=0;
    static void solve(){
        int s = 0;

        for (int i=0;i<k;i++){
            put(arr[i]);
        }

        result = now;

        for (int i=1;i<=n;i++){
            remove(arr[i-1]);
            int putIndex = i+k-1;
            if (putIndex>=n)
                putIndex-=n;
            put(arr[putIndex]);

            int tmp;
            if (type[c]==0){
                tmp = 1;
            }else{
                tmp = 0;
            }

            if (result < now + tmp){

                result = now + tmp;
            }
        }
    }
    static void put(int i){
        if (type[i]==0){
            now++;
        }
        type[i]++;
    }
    static void remove(int i){
        if (type[i]==1){
            now--;
        }
        type[i]--;
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