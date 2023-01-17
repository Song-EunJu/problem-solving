import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//출발지에서 도착지까지 가는 경로 중에 복구 시간이 가장 짧은 경로에 대한 총 복구 시간
public class test2 {
    static int n;
    static int arr[][]; // 원본배열
    static int dp[][]; // 수정배열
    static boolean visit[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            dp = new int[n][n];

            visit = new boolean[n][n];
            for(int j=0;j<n;j++){
                Arrays.fill(dp[j], Integer.MAX_VALUE);
                String s = br.readLine();
                for(int k=0;k<n;k++){
                    arr[j][k] = s.charAt(k)-'0';
                }
            }
            dp[0][0] = 0;
            bfs(0, 0);
            sb.append("#"+(i+1)+" "+dp[n-1][n-1]+"\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i,j});

        while(!q.isEmpty()){
            int nowY = q.peek()[0];
            int nowX = q.peek()[1];
            visit[nowY][nowX] = true;
            q.poll();

            for(int k=0;k<4;k++){
                int posY = nowY + dy[k];
                int posX = nowX + dx[k];

                if(posY >= 0 && posY < n && posX >= 0 && posX < n && visit[posY][posX] == false){
                    if(dp[posY][posX] >= dp[nowY][nowX] + arr[posY][posX]) {
                        dp[posY][posX] = dp[nowY][nowX] + arr[posY][posX];
                        q.add(new int[]{posY, posX});
                    }
                }
            }
        }
    }
}