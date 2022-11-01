import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Position {
    int y;
    int x;

    Position(int y, int x){
        this.y = y;
        this.x = x;
    }
}
public class baekjoon2667 {
    static int[][] arr;
    static boolean[][] visited;
    static int dy[] = {-1,1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static int n;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<n;j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 1 && visited[i][j] == false) // 방문하지 않은 집인 경우에 bfs 시작
                    bfs(i,j);
            }
        }

        Collections.sort(list);
        sb.append(list.size()+"\n");
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i)+"\n");
        }
        System.out.println(sb);
    }

    // 주변에 있는 집을 모두 찾아야 하니까 BFS
    // 1인 지점의 i,j를 가지고 상하좌우 dx,dy로 돌면서 방문한 적 없는 1인 애들을 다 센다.
    public static void bfs(int y, int x) {
        int cnt=0;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(y,x));
        visited[y][x] = true;
        cnt++;
        while(!queue.isEmpty()){
            Position pos = queue.poll();
            int py = pos.y;
            int px = pos.x;
            for(int i=0;i<4;i++){
                int posY = py+dy[i];
                int posX = px+dx[i];
                if((posY>=0 && posY<n) && (posX>=0 && posX<n) && arr[posY][posX]==1 && visited[posY][posX]==false){
                    queue.add(new Position(posY, posX));
                    visited[posY][posX] = true;
                    cnt++;
                }
            }
        }
        list.add(cnt);
    }
}