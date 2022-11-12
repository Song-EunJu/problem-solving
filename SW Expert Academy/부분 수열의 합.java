import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 최소 1개 이상의 수를 선택해서 그 합이 K가 되는 경우의 수를 구하자
 * 1개씩 방문처리를 하면서 더해가면서 K가 되는 순간 cnt++;
 */

public class test {
    static int K;
    static boolean visited[];
    static int arr[];
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            visited = new boolean[N];
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            sb.append("#"+(i+1)+" "+cnt+"\n");
            cnt = 0;
        }
        System.out.println(sb);
    }

    public static void dfs(int sum, int idx){
        if(sum == K)
            cnt++;

        for(int i=idx;i<arr.length;i++){
            visited[i] = true;
            dfs(sum + arr[i], i+1);
            visited[i] = false;
        }
    }
}
