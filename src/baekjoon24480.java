import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
* dfs 처음에 if(cnt==n) return; 문을 넣었었는데,
* n일 경우에도 return 문 아래의 작업을 수행하고 끝나야 하므로 해당 문장을 삭제
* */
public class baekjoon24480 {
    static List<List<Integer>> list;
    static int n;
    static boolean visited[];
    static int cnt = 1;
    static int answer[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점 수
        int m = Integer.parseInt(st.nextToken()); // 간선 수
        int r = Integer.parseInt(st.nextToken()); // 시작정점
        list = new ArrayList<>(n+1);

        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        visited = new boolean[n+1]; // 정점 방문 여부
        answer = new int[n];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i=1;i<=n;i++){ // 내림차순 정렬
            Collections.sort(list.get(i), Collections.reverseOrder());
        }

        dfs(r);
        for(int i=0;i<n;i++){
            sb.append(answer[i]+"\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int start) {
        // 해당 정점을 방문했다고 처리하고 cnt 값을 넣어주면서 방문 순서를 체크
        visited[start] = true;
        answer[start-1] = cnt;
        for (int i=0;i<list.get(start).size();i++) { // 내림차순으로 방문하기 위해서 끝에서부터 접근
            if (visited[list.get(start).get(i)] == false) {
                cnt++;
                dfs(list.get(start).get(i));
            }
        }
    }
}
