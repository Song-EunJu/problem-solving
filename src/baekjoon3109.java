import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon3109 {
    static char bread[][];
    static int dy[] = {-1, 0, 1};
    static boolean visit[][];
    static int R,C;
    static int cnt = 0;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        bread = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                bread[i][j] = s.charAt(j);
            }
        }

        /**
         1번 경로에서 나올 수 있는게 a,b,c 경로가 있다고 가정
         -> a경로를 선택했을 때 뒤에서 1개만 더 선택할 수 있다고 가정
         -> 만약에 b 경로를 선택했다면 뒤에서 3개를 더 선택할 수 있었다면 ?
         -> 그니까 하나의 경로를 선택한 다음에는 / y 인덱스 다음 지점으로 돌아가서 다시 뽑는 식으로 진행.
         */
        start(0, 0, 0);
        System.out.println(max);
    }

    public static void start(int y, int x, int yIdx){
        if(yIdx==C) { // R 만큼 다 뽑았을 때
            max = Math.max(max, cnt);
            System.out.println(max+" "+cnt);
            cnt = 0;
            visit = new boolean[R][C];
        }

        if(x==C) { // 마지막 열에 도착한 경우 (하나의 선택이 끝난 경우)
            cnt++;
            max = Math.max(max, cnt);
            start(yIdx+1, 0, yIdx+1);
            return;
        }

        for(int i=0;i<3;i++){
            int nowY = y+dy[i];
            int nowX = x+1;
            if(promising(nowY, nowX)){
                visit[nowY][nowX] = true;
                start(nowY, nowX, yIdx);
                visit[nowY][nowX] = false;
            }
        }
    }

    // 한 경로 갔을 때

    public static boolean promising(int y, int x){
        if(y>=0 && y<R && !visit[y][x] && bread[y][x]!='x') // Y가 범위안에 들어있고, 방문하지 않았고, 건물이 아닌 경우에만
            return true;
        return false;
    }
}
