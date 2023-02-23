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

        for(int i=0;i<R;i++) { // R번만큼 돌면서 시작지점은 계속 바꿔줘야 함
            start(i, 0);
        }

        System.out.println(cnt);
    }

    /**
     * 사고 정리가 안됨.
     *
     * 1번 경로에서 나올 수 있는게 a,b,c 경로가 있다고 가정
     *          -> a경로를 선택했을 때 뒤에서 1개만 더 선택할 수 있다고 가정
     *          -> 만약에 b 경로를 선택했다면 뒤에서 3개를 더 선택할 수 있었다면 ?
     *          -> 그니까 하나의 경로를 선택한 다음에는, y 인덱스 다음 지점으로 돌아가서 다시 뽑는 식으로 진행하려고 했는데!
     *          -> 그러면 최단 경우의수를.. 못 구 하는.. ?
     *
     * 그렇다면 그리디인가?
     * -> 갈림길이 여러개 나오는 경우, 그 순간의 최선의 선택을 하여 최댓값을 구해야 함
     * -> 근데 그 순간에 최선인지 아닌지 어떻게 알지? 무조건 안 겹치게 오른쪽 상단으로 올려야 하는 건가...
     * [결론] 오른쪽 상단부터 가는 게 맞았음. 오른쪽 상단 - 오른쪽 - 오른쪽 아래 순서대로 for문 돌면서 파이프라인 생성되면
     *          바로 true 처리하고 다시 맨 첫번째좌표로 돌아가서 새로운 파이프라인을 찾도록 함
     * */
    public static boolean start(int y, int x){
        if(x==C-1) { // 마지막 열에 도착한 경우
            cnt++;
            return true;
        }

        int nowX = x+1;
        for(int i=0;i<3;i++){
            int nowY = y+dy[i]; // 탐색의 순서가 오른쪽 위 - 오른쪽 - 오른쪽 아래로 해야 최적 경로 찾음

            if(promising(nowY, nowX)){
                visit[nowY][nowX] = true;
                if(start(nowY, nowX))
                    // 마지막 열에 도착해서 파이프생성이 true 인 경우에는, 다른 갈림길이 가능하더라도 가지 않기 위해 true 를 리턴
                    return true;
                /** 여기서 break 하면 안되는 경우 : return false 하게 되니까 갈림길을 계속 탐방하게 됨*/
            }
        }
        return false;
    }

    // 한 경로 갔을 때
    public static boolean promising(int y, int x){
        // Y, X가 배열 내의 인덱스이며, 방문하지 않았고, 건물이 아닌 경우
        if((y>=0 && y<R) && (x>=0 && x<C) && !visit[y][x] && bread[y][x]!='x')
            return true;
        return false;
    }
}
