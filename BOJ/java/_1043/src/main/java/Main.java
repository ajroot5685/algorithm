import java.io.*;
import java.util.*;

public class Main {

    static FastReader scan = new FastReader();

    static ArrayList<Integer>[] person;
    static ArrayList<Integer>[] party;
    static ArrayList<Integer> know;

    static int n;
    static int m;

    public static void main(String[] args) {
        input();
        solve();
    }

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();

        person = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            person[i] = new ArrayList<>();
        }

        party = new ArrayList[m + 1];
        for (int i = 1; i <= m; i++) {
            party[i] = new ArrayList<>();
        }

        know = new ArrayList<>();

        int knowNum = scan.nextInt();

        for (int i = 0; i < knowNum; i++) {
            know.add(scan.nextInt());
        }

        for (int i = 1; i <= m; i++) {
            int partyNum = scan.nextInt();
            for (int j = 0; j < partyNum; j++) {
                int peopleNum = scan.nextInt();

                party[i].add(peopleNum);
                person[peopleNum].add(i);
            }
        }
    }

    static void solve() {
        int result = m;

        boolean[] visited = new boolean[m + 1];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < know.size(); i++) {
            queue.add(know.get(i));
        }

        while (!queue.isEmpty()) {
            int check = queue.poll();

            for (int i = 0; i < person[check].size(); i++) {
                int partyNum = person[check].get(i);

                if (visited[partyNum]) {
                    continue;
                }
                visited[partyNum] = true;
                result--;

                for (int j = 0; j < party[partyNum].size(); j++) {
                    int peopleNum = party[partyNum].get(j);
                    if (check != peopleNum) {
                        queue.add(peopleNum);
                    }
                }
            }
        }

        System.out.println(result);
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
