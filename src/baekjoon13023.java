import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon13023 {
    static List<List<Integer>> list;
    static boolean visit[];
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            visit[i] = true;
            dfs(i, 0);
            if (flag) {
                System.out.println("1");
                return;
            }
        }
        System.out.println(0);
    }

    public static void dfs(int start, int cnt) {
        if (cnt == 4) {
            flag = true;
            return;
        }

        for (int n : list.get(start)) {
            if (visit[n])
                continue;
            visit[n] = true;
            dfs(n, cnt + 1);
            visit[n] = false;
        }
    }
}