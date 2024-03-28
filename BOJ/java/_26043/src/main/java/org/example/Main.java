package org.example;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static FastReader scan = new FastReader();
    //정답은 sb에 append 를 사용하여 출력
    //만약 개행까지 출력하고 싶으면 append('\n')을 추가
    static StringBuilder sb = new StringBuilder();

    static int n;
    static Deque<Integer> student = new LinkedList<>();
    static HashMap<Integer, Integer> like = new HashMap<>();
    static List<Integer> a = new ArrayList<>();
    static List<Integer> b = new ArrayList<>();
    static List<Integer> c = new ArrayList<>();

    public static void main(String[] args) {
        input();
    }
    static void input(){
        n = Integer.parseInt(scan.nextLine());

        for (int i=0;i<n;i++){
            solve(scan.nextLine());
        }

        if (student.size()!=0){
            for (int i=0;i<student.size();){
                c.add(student.pollFirst());
            }
        }

        if (a.size()==0){
            System.out.println("None");
        }else{
            format_print(a);
        }

        if (b.size()==0){
            System.out.println("None");
        }else{
            format_print(b);
        }

        if (c.size()==0){
            System.out.println("None");
        }else{
            format_print(c);
        }

    }
    static void format_print(List<Integer> list){
        Collections.sort(list);
        String result = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
    static void solve(String s){
        StringTokenizer st = new StringTokenizer(s);
        int type = Integer.parseInt(st.nextToken());
        if (type==1){
            int stu = Integer.parseInt(st.nextToken());
            student.offerLast(stu);

            int slike = Integer.parseInt(st.nextToken());
            like.put(stu, slike);
        }else {
            int menu = Integer.parseInt(st.nextToken());
            int stu = student.pollFirst();

            int slike = like.get(stu);

            if (menu==slike){
                a.add(stu);
            }else{
                b.add(stu);
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
