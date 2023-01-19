import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 1. 우선 순위큐 없이 다익스트라로 구현
public class test2 {
    static int n;
    static int arr[][]; // 원본배열
    static int dp[][]; // 수정배열
    static int dy[] = {1, -1, 0, 0};
    static int dx[] = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n]; // 원본 배열
            dp = new int[n][n]; // 누적합을 구하는 배열
            for(int j=0;j<n;j++){
                Arrays.fill(dp[j], Integer.MAX_VALUE); // dp는 INF 넣어두기
                String s = br.readLine();
                for(int k=0;k<n;k++){
                    arr[j][k] = s.charAt(k)-'0';
                }
            }
            dp[0][0] = 0;
            bfs();
            sb.append("#"+(i+1)+" "+dp[n-1][n-1]+"\n");
        }
        System.out.println(sb);
    }

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0});

        while(!q.isEmpty()){
            int now[] = q.poll();
            int nowY = now[0];
            int nowX = now[1];

            for(int k=0;k<4;k++){
                int posY = nowY + dy[k];
                int posX = nowX + dx[k];

                if(posY >= 0 && posY < n && posX >= 0 && posX < n){
                    if(dp[posY][posX] > dp[nowY][nowX] + arr[posY][posX]) {
                        dp[posY][posX] = dp[nowY][nowX] + arr[posY][posX];
                        q.add(new int[]{posY, posX});
                    }
                }
            }
        }
    }
}
