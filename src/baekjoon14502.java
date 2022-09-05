import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 벽 3개 세우기
 * 벽은 3개를 세워야하는데, 안전 영역의 최대크기를 계산하기 위해서는
 * 어느 위치에 벽을 세워야 최적인지 알아야 한다 = 그러려면 3개의 벽을 각 위치마다 세워봐야 함
 * 그럼,,DFS 를 이용해서 하나 세우고 다시 FOR문 돌면서 하나 세우고, 하면서 3개인 경우 리턴해서
 * 그 즉시 안전영역 크기를 구해야 한다.
 *
 * 2. 안전영역 크기 구하기
 * 안전영역은 0인 구역의 인접 영역을 다 더해야 하므로 BFS가 필요
 * */
public class baekjoon14502 {
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    /**
     * dy dx
     * -1 0 상
     * 1 0 하
     * 0 -1 좌
     * 0 1 우
     */
    static int arr[][];
    static int res = Integer.MIN_VALUE;
    static int visit[][];
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }
        dfs(0);
        System.out.println(res);// 바이러스 퍼뜨리고 -> 안전영역(0으로만 이루어진 거 계산)
    }
    public static void dfs(int wall) {
        // 0인 위치에만 벽을 세우면서 벽이 3개가 되면 바이러스를 퍼뜨리러감
        // arr : 기존 배열
        // visit : 벽을 세운 후 배열
        if (wall == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(wall + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void spreadVirus(){
        Queue<Integer[]> q = new LinkedList<>();

        // 벽 세운 배열을 visit에 넣기
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visit[i][j] = arr[i][j];
            }
        }

        // 배열 원소 중 바이러스인 애를 큐에 넣고, 각 바이러스들이 주변으로 퍼져나가게 함
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] == 2) {
                    q.add(new Integer[]{i, j});
                }
            }
        }

        while(!q.isEmpty()){
            Integer[] pop = q.remove();
            int y = pop[0];
            int x = pop[1];
            for(int i=0;i<4;i++){ // 상하좌우로 바이러스가 퍼져갈 수 있음
                int posY = y+dy[i];
                int posX = x+dx[i];
                if((posY>=0 && posY<n) && (posX>=0 && posX<m) && visit[posY][posX]==0) {
                    visit[posY][posX] = 2;
                    q.add(new Integer[]{posY, posX});
                }
            }
        }
        // 한턴이 끝나면 안전영역을 계산하러감
        safeArea();
    }
    public static void safeArea(){
        int cnt = 0;
        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] == 0) {
                    cnt++;
                }
            }
        }
        res = Math.max(res, cnt);
    }
}
