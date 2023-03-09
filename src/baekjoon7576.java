import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon7576 {
    static class Pos{
        int y;
        int x;
        int day;

        public Pos(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }
    static Queue<Pos> q = new LinkedList<>();
    static boolean visited[][];
    static int tomatoes[][];
    static int dy[] = {1, -1, 0, 0};
    static int dx[] = {0, 0, 1, -1};
    static int N, M;
    static int possibleTomato;
    public static void main(String[] args) throws IOException {
        // 하루가 지나면 인접한 익지 않은 애들도 익게 됨.
        // 며칠이 지나면 다 익게되는지 최소 일수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        tomatoes = new int[N][M];
        visited = new boolean[N][M];

        // 0의 개수를 세고 큐에서 넣을 때마다 개수를 감소시켜서 0이 안되면 -1 출력
        possibleTomato = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int num = Integer.parseInt(st.nextToken());
                tomatoes[i][j] = num;
                if(num == 1) {// 토마토인 애를 출발점으로 해야하므로 그 즉시 큐에 넣음
                    q.add(new Pos(i, j, 0));
                    visited[i][j] = true;
                }
                else if(num == 0)
                    possibleTomato++;
            }
        }
        bfs();
    }

    public static void bfs(){
        int finalDay = 0;
        while(!q.isEmpty()){
            Pos cur = q.poll();
            int curY = cur.y;
            int curX = cur.x;
            int curDay = cur.day;

            for(int i=0;i<4;i++){
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];
                int nextDay = curDay + 1;
                if(nextY < 0 || nextY >= N || nextX < 0 || nextX >= M)
                    continue;

                if(tomatoes[nextY][nextX] == 0 && !visited[nextY][nextX]){
                    q.add(new Pos(nextY, nextX, nextDay));
                    visited[nextY][nextX] = true;
                    possibleTomato--;
                }
            }
            finalDay = curDay;
        }
        System.out.println(possibleTomato == 0 ? finalDay : -1);
    }
}
