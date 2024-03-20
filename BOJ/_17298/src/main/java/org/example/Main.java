package org.example;


import java.io.*;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    //정답은 sb에 append 를 사용하여 출력
    //만약 개행까지 출력하고 싶으면 append('\n')을 추가
    static StringBuilder sb = new StringBuilder();
    static int n;
    static Deque<Integer> deque = new LinkedList<>();
    static int[] result;

    public static void main(String[] args) {
        input();

        for(int i=0;i<n;i++){
            if (sb.length()>0){
                sb.append(" ");
            }
            sb.append(result[i]);
        }

        System.out.println(sb.toString());
    }
    static void input(){
        n = Integer.parseInt(scan.next());
        result = new int[n];

        for (int i=0;i<n;i++){
            result[i]=Integer.parseInt(scan.next());
        }

        solve();
    }
    static void solve(){
        for (int i=0;i<n;i++){
            while(!deque.isEmpty() && result[deque.peekFirst()]<result[i]){
                result[deque.pollFirst()]=result[i];
            }
            deque.offerFirst(i);
        }
        for (int i=0;i<deque.size();){
            result[deque.pollFirst()]=-1;
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
