//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//
////출발지에서 도착지까지 가는 경로 중에 복구 시간이 가장 짧은 경로에 대한 총 복구 시간
//public class test2 {
//    static int n;
//    static int arr[][]; // 원본배열
//    static int dp[][]; // 수정배열
//    static boolean visit[][];
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
//            visit = new boolean[n][n]; // 방문 배열
//            for(int j=0;j<n;j++){
//                Arrays.fill(dp[j], Integer.MAX_VALUE);
//                String s = br.readLine();
//                for(int k=0;k<n;k++){
//                    arr[j][k] = s.charAt(k)-'0';
//                }
//            }
//
//            for(int j=0;j<n;j++){
//                for(int k=0;k<n;k++){
//                    System.out.print(arr[j][k]);
//                }
//                System.out.println();
//            }
//            dp[0][0] = 0;
//            bfs();
//            sb.append("#"+(i+1)+" "+dp[n-1][n-1]+"\n");
//        }
//        System.out.println(sb);
//    }
//
//    public static void bfs(){
//        Queue<int[]> q = new LinkedList<>();
//        q.add(new int[] {0,0});
//        visit[0][0] = true;
//
//        while(!q.isEmpty()){
//            int now[] = q.poll();
//            int nowY = now[0];
//            int nowX = now[1];
//            visit[nowY][nowX] = true;
//
//            for(int k=0;k<4;k++){
//                int posY = nowY + dy[k];
//                int posX = nowX + dx[k];
//
//                if(posY >= 0 && posY < n && posX >= 0 && posX < n && visit[posY][posX] == false){
//                    if(dp[posY][posX] > dp[nowY][nowX] + arr[posY][posX]) {
//                        dp[posY][posX] = dp[nowY][nowX] + arr[posY][posX];
//                        q.add(new int[]{posY, posX});
//                    }
//                }
//            }
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class test2 {
    static int N,ans;
    static boolean[][] visited;
    static int[][] map;
    static int[][] count;
    static int[] dx= {-1,1,0,0};
    static int[] dy= {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            N = Integer.parseInt(br.readLine());

            ans = Integer.MAX_VALUE;
            map = new int[N][N];
            count = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String temp = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = temp.charAt(j)-'0';
                }
            }
            for (int i = 0; i < N; i++) {
                Arrays.fill(count[i], Integer.MAX_VALUE);
            }
            count[0][0] = 0;
            bfs();
            sb.append("#"+tc+" "+ans+"\n");
        }
        System.out.println(sb);
    }
    private static void bfs() {
        Queue<point> q = new LinkedList<>();
        q.add(new point(0,0));
        visited[0][0] = true;
        while(!q.isEmpty()) {
            point temp = q.poll();

            if(temp.x ==N-1 && temp.y==N-1) {
                ans = ans > count[N-1][N-1]?count[N-1][N-1]:ans;
            }

            for (int k = 0; k < 4; k++) {
                int xx = temp.x + dx[k];
                int yy = temp.y + dy[k];
                if(xx<0||xx>=N||yy<0||yy>=N)continue;
                if(!visited[xx][yy] || count[xx][yy]> count[temp.x][temp.y]+map[xx][yy]) {
                    visited[xx][yy] = true;
                    count[xx][yy] = count[temp.x][temp.y]+map[xx][yy];
                    q.offer(new point(xx, yy));
                }
            }
        }
    }

    static class point{
        int x;
        int y;
        public point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
}