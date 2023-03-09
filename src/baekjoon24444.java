import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon24444 {
    static List<Integer>[] list;
    static boolean visit[];
    static int order[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        visit = new boolean[N+1];
        order = new int[N+1];

        for(int i=0;i<=N;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=1;i<=N;i++)
            Collections.sort(list[i]);

        bfs(R);
        for(int i=1;i<=N;i++){
            sb.append(order[i]+"\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int num) {
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        visit[num] = true;
        order[num] = cnt++;

        while(!q.isEmpty()){
            int remove = q.poll();
            for(int adjNum : list[remove]){
                if(!visit[adjNum]){
                    q.add(adjNum);
                    visit[adjNum] = true;
                    order[adjNum] = cnt++;
                }
            }
        }
    }
}
