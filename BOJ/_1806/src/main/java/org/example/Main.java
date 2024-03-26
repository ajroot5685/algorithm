package org.example;


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    static StringBuilder sb = new StringBuilder();

    static int n,s;
    static int[] arr;
    static int result = 100001;

    public static void main(String[] args) {
        input();
        solve();
        if (result == 100001){
            System.out.println(0);
        }else{
            System.out.println(result);
        }
    }
    static void input(){
        n = scan.nextInt();
        s = scan.nextInt();

        arr = new int[n];

        for (int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }

    }
    static void solve(){
        int start = 0;
        int end = 0;

        int sum = 0;
        int length = 0;

        while(end<=n){
            if (sum>=s){
                if (result>length){
                    result = length;
                }
                sum-=arr[start];
                start++;
                length--;
            }else if(end==n){
                return;
            }else{
                sum+=arr[end];
                end++;
                length++;
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