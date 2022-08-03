import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon24445 {
    public static Queue<Integer> queue = new LinkedList<>();
    public static int order[];
    public static boolean visit[];
    public static int cnt = 1;
    public static void bfs(int start, List<List<Integer>> list){
        // 일단 큐에 넣고 빼면서 인접한 애들 넣기
        queue.add(start);
        visit[start] = true;

        while(!queue.isEmpty()){
            int num = queue.remove();
            order[num] = cnt++;

            for(int i=0;i<list.get(num).size();i++){ // 1과 인접한 4,2 순서대로 넣기
                int n = list.get(num).get(i);
                if(visit[n] == false) {
                    queue.add(n);
                    visit[n] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        order = new int[n+1];
        visit = new boolean[n+1];
        int start = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>(n+1);
        for(int i=0;i<n+1;i++){
            list.add(new ArrayList<>());
        }

        // 인접리스트로 구현하자
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(s).add(e);
            list.get(e).add(s);
        }
        for(int i=1;i<n+1;i++){ // 내림차순 정렬 어케 하는 건데
            Collections.sort(list.get(i), Collections.reverseOrder());
        }

        bfs(start, list);
        for(int i=1;i<n+1;i++){
            sb.append((visit[i]==true ? order[i] : 0)+"\n");
        }
        System.out.println(sb);
    }
}
