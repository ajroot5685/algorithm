package org.example;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    //정답은 sb에 append 를 사용하여 출력
    //만약 개행까지 출력하고 싶으면 append('\n')을 추가
    static StringBuilder sb = new StringBuilder();

    // left head - left end - right head - right end 순
    static Deque<Character> left = new LinkedList<>();
    static Deque<Character> right = new LinkedList<>();

    static int n;

    public static void main(String[] args) {
        input();
    }
    static void input(){
        char[] c = scan.nextLine().toCharArray();

        for (int i=0;i<c.length;i++){
            left.offerLast(c[i]);
        }

        n = Integer.parseInt(scan.nextLine());

        for (int i=0;i<n;i++){
            solve(scan.nextLine());
        }

        for (int i=0;i<left.size();){
            sb.append(left.pollFirst());
        }

        for (int i=0;i<right.size();){
            sb.append(right.pollFirst());
        }

        System.out.println(sb.toString());
    }
    static void solve(String s){
        if (s.equals("L")){
            if (left.size()>0) {
                right.offerFirst(left.pollLast());
            }
        }else if(s.equals("D")){
            if (right.size()>0){
                left.offerLast(right.pollFirst());
            }
        }else if(s.equals("B")){
            if (left.size()>0){
                left.pollLast();
            }
        }else{
            StringTokenizer st = new StringTokenizer(s);
            st.nextToken();
            char c = st.nextToken().charAt(0);
            left.offerLast(c);
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
