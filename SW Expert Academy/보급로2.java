import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 다익스트라 : 한 노드에서 각 모든 노드까지의 최단 거리를 구하는 알고리즘
 * = 가중치가 다른 그래프에서 최단 경로를 찾는 알고리즘으로, BFS + DP
 *
 *  다익스트라에서는 왜 방문 여부를 체크해주면 오히려 오답이 나올까?
 *  -> visit 체크를 하면 나중에 발견된 경로가 더 짧아도 무시됨
 *
 *  다익스트라는 그냥 큐가 아니라 우선순위큐로도 구현할 수 있음
 *  우선순위 큐는 힙 자료구조를 이용해 빠르게 작동하도록 만들 수 있으며,
 *  이를 이용하면 특정 노드까지의 최단 거리에 대한 정보를 힙에 담아 처리할 수 있음
 *  PriorityQueue는 비용이 가장 낮은 것을 우선순위로 하여 추출하는 큐
 *  = 시간이 덜 걸리는 곳을 먼저 꺼내서 탐색하는 것 (시간이 작은 것을 먼저 빼야하니까 좌표값과 time 도 함께 저장해야 함)
 *
 *
 * */

class Pos implements Comparable<Pos> {
    private int y;
    private int x;
    private int dist;
    public Pos(int y, int x, int dist){
        this.y = y;
        this.x = x;
        this.dist = dist;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getDist() {
        return dist;
    }

    @Override
    public int compareTo(Pos o) {
        return this.dist - o.dist;
    }

    /**
     * Comparable : 자기자신과 매개변수 객체를 비교
     * -> 자기자신을 기준으로 삼아 대소관계 파악해야 함
     * 나 - 다른 사람 > 0 이면 양수 반환, 나 - 다른 사람 < 0 이면 음수 반환해야 하므로
     * 위의 식 하나로 정리 가능
     */
}
public class test2 {
    static int n;
    static int min;
    static int arr[][]; // 원본배열
    static int dp[][]; // 수정배열
    static int dy[] = {1, -1, 0, 0};
    static int dx[] = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++) {
            min = Integer.MAX_VALUE;
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
            sb.append("#"+(i+1)+" "+min+"\n");
        }
        System.out.println(sb);
    }

    public static void bfs(){
        PriorityQueue<Pos> q = new PriorityQueue<>();
        q.add(new Pos(0,0, 0));

        while(!q.isEmpty()){
            Pos pos = q.poll();
            int nowY = pos.getY();
            int nowX = pos.getX();
            int nowDist = pos.getDist();

            if(nowY == n-1 && nowX == n-1)
                min = Math.min(nowDist, min);

            for(int k=0;k<4;k++){
                int posY = nowY + dy[k];
                int posX = nowX + dx[k];

                if(posY >= 0 && posY < n && posX >= 0 && posX < n){
                    if(dp[posY][posX] > nowDist + arr[posY][posX]) {
                        dp[posY][posX] = nowDist + arr[posY][posX];
                        q.add(new Pos(posY, posX, dp[posY][posX]));
                    }
                }
            }
        }
    }
}