import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Board {
    int y;
    int x;
    int dist;

    public Board(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}
public class baekjoon1987 {
    static int R, C;
    static int max = Integer.MIN_VALUE;
    static char arr[][];
    static boolean visit[][];
    static boolean alphabet[];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0 , 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visit = new boolean[R][C];
        alphabet = new boolean[26];
        for(int i=0;i<R;i++){
            arr[i] = br.readLine().toCharArray();
        }

        visit[0][0] = alphabet[arr[0][0]-65] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }

    public static void dfs(int y, int x, int cnt){
        for(int i=0;i<4;i++){
            int posY = y + dy[i];
            int posX = x + dx[i];

            // 범위에 속하거나, 방문하지 않은 지점이고, 알파벳도 사용하지 않은 거라면
            if(inRange(posY, posX) && !visit[posY][posX] && !alphabet[arr[posY][posX]-65]) {
                visit[posY][posX] = alphabet[arr[posY][posX]-65] = true;
                dfs(posY, posX, cnt+1);
                visit[posY][posX] = alphabet[arr[posY][posX]-65] = false;
            }
        }
        max = Math.max(max, cnt);
    }

    public static boolean inRange(int y, int x){
        if(y>=0 && y<R && x>=0 && x<C)
            return true;
        return false;
    }
}
