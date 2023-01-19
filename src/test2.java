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

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.PriorityQueue;
//
////출발지에서 도착지까지 가는 경로 중에 복구 시간이 가장 짧은 경로에 대한 총 복구 시간
///**
// * 다익스트라 : 한 노드에서 각 모든 노드까지의 최단 거리를 구하는 알고리즘
// * = 가중치가 다른 그래프에서 최단 경로를 찾는 알고리즘으로, BFS + DP
// *
// *  다익스트라에서는 왜 방문 여부를 체크해주면 오히려 오답이 나올까?
// *  -> visit 체크를 하면 나중에 발견된 경로가 더 짧아도 무시됨
// *
// *  이 문제는 그냥 큐가 아니라 우선순위큐로도 구현할 수 있음
// *  PriorityQueue는 비용이 가장 낮은 것을 우선순위로 하여 추출하는 큐
// *  = 시간이 덜 걸리는 곳을 먼저 꺼내서 탐색하는 것 (시간이 작은 것을 먼저 빼야하니까 좌표값과 time 도 함께 저장해야 함)
// *
// *
// * */
//
//class Pos{
//    private int y;
//    private int x;
//    public Pos(int y, int x){
//        this.y = y;
//        this.x = x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    @Override
//    public int compareTo(Pos p){
//        if(this.)
//    }
//
//}
//public class test2 {
//    static int n;
//    static int arr[][]; // 원본배열
//    static int dp[][]; // 수정배열
//    static int dy[] = {1, -1, 0, 0};
//    static int dx[] = {0, 0, 1, -1};
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int T = Integer.parseInt(br.readLine());
//        for (int i=0;i<T;i++) {
//            n = Integer.parseInt(br.readLine());
//            arr = new int[n][n]; // 원본 배열
//            dp = new int[n][n]; // 누적합을 구하는 배열
//            for(int j=0;j<n;j++){
//                Arrays.fill(dp[j], Integer.MAX_VALUE); // dp는 INF 넣어두기
//                String s = br.readLine();
//                for(int k=0;k<n;k++){
//                    arr[j][k] = s.charAt(k)-'0';
//                }
//            }
//            dp[0][0] = 0;
//            bfs();
//            sb.append("#"+(i+1)+" "+dp[n-1][n-1]+"\n");
//        }
//        System.out.println(sb);
//    }
//
//    public static void bfs(){
//        PriorityQueue<Pos> q = new PriorityQueue<>();
//        q.add(new Pos(0,0));
//
//        while(!q.isEmpty()){
//            Pos pos = q.poll();
//            int nowY = pos.getY();
//            int nowX = pos.getX();
//
//            for(int k=0;k<4;k++){
//                int posY = nowY + dy[k];
//                int posX = nowX + dx[k];
//
//                if(posY >= 0 && posY < n && posX >= 0 && posX < n){
//                    if(dp[posY][posX] > dp[nowY][nowX] + arr[posY][posX]) {
//                        dp[posY][posX] = dp[nowY][nowX] + arr[posY][posX];
//                        q.add(new Pos(posY, posX));
//                    }
//                }
//            }
//        }
//    }
//}