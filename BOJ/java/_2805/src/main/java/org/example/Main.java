package org.example;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] tree;

    public static void main(String[] args) {
        input();
        int result = solve();
        System.out.println(result);
    }
    static void input(){
        n = scan.nextInt();
        m = scan.nextInt();

        tree = new int[n];

        for (int i=0;i<n;i++){
            tree[i] = scan.nextInt();
        }

        Arrays.sort(tree);
    }
    static int solve(){
        int start = 0;
        int end = tree[n-1];
        int result = 0;

        while(start<=end){
            int mid = (start+end)/2;
            long sum=take_sum(mid);

            if (sum<m){
                end = mid - 1;
            }else{
                start = mid + 1;
                if (result<mid){
                    result = mid;
                }
            }
        }
        return result;
    }
    static long take_sum(int cut){
        long sum = 0;
        for (int i=0;i<n;i++){
            if (cut<tree[i]){
                sum+=(tree[i]-cut);
            }
        }
        return sum;
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
