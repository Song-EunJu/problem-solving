import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon24479 {
    static int n;
    static Stack<Integer> stack = new Stack<>();
    static int arr[][];
    static int order[];
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점
        arr = new int[n+1][n+1]; // 인접행렬
        order = new int[n+1]; // 순서 출력할 배열
        visit = new boolean[n+1]; // 방문 여부 배열
        int m = Integer.parseInt(st.nextToken()); // 간선
        int r = Integer.parseInt(st.nextToken()); // 시작 정점

        for(int i=0;i<m;i++){ // 무방향 그래프이므로 두 부분 다 1로 초기화
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        dfs(r, 1);
        for(int i=1;i<=n;i++){
            if(visit[i] == false)
                System.out.println(0);
            else
                System.out.println(order[i]);
        }
    }
    public static void dfs(int start, int count){
        stack.push(start);
        visit[start] = true;
        int top = stack.peek();
        order[stack.pop()] = count;

        for(int i=1;i<=n;i++){
            if(arr[top][i]==1 && visit[i] == false){
                dfs(i, count+1);
            }
        }
    }
}
