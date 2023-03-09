import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 많이 깨뜨리려면 맨위에서 수가 큰 거 있는 거 부터 깨야 함

public class 벽돌깨기 {
    static int N, W, H;
    static int bricks[][];
    static int brickNum; // 전체 벽돌 수
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=0;t<T;t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            bricks = new int[H][W];
            brickNum = 0;
            int minH = H; // 처음 0이 아닌 벽돌이 등장하는 행 번호
            for(int i=0;i<H;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<W;j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if(num != 0) {
                        brickNum++;
                        minH = Math.min(i, minH);
                    }
                    bricks[i][j] = num;
                }
            }

            // 구슬을 한번 깰 때마다 어떤 열 최상단에 가장 큰 숫자가 쓰여진 벽돌이 있는지 확인해야 함
            // 그 때 그 때 최선의 선택을 하기 위해서라면 그리디적인 접근 ? 근데 (1,9) 가 답이 아닌거 보면 그리디 아닌 듯..

            // 어떤 구슬을 깨뜨릴 건지 선택하는 경우의 수 구하기
            for(int i=minH;i<H;i++) {
                for(int j=0;j<W;j++) {
                    if(bricks[i][j] != 1) {

                    }
                }
            }
            int num = 3;
            int posY = 0, posX = 0;

            // 사방의 좌표를 큐에 넣고, 큐에서 꺼내면서 써있는 해당 숫자의 상하좌우만큼을 또 큐에 넣음
            for(int i=0;i<N;i++) {
                q = new LinkedList<>();
                while(!q.isEmpty()) {
                    int[] now = q.poll();
                    int nowY = now[0];
                    int nowX = now[1];
                    int brickN = bricks[nowY][nowX];

                    int wide = brickNum-1;
                    if(wide < 0) // 0인 경우에는 아무것도 안함
                        continue;

                    bricks[nowY][nowX] = 0;
                    brickNum--;

                    breakMarble(nowY, nowY, nowX-wide < 0 ? 0 : nowX-wide, nowX); // 좌
                    breakMarble(nowY, nowY, nowX, nowX+wide > W-1 ? W-1 : nowX+wide); // 우
                    breakMarble(nowY-wide < 0 ? 0 : nowY-wide, nowY, nowX, nowX); // 상
                    breakMarble(nowY, nowY+wide > H-1 ? H-1 : nowY+wide, nowX, nowX); // 하
                }

                // 다 터뜨리고 벽돌은 밑으로 떨어짐
            }
            System.out.println("#"+(t+1)+" "+brickNum);
        }
    }

    public static void breakMarble(int bY, int aY, int bX, int aX) {
        if(bY == aY) { // 좌우 인 경우
            for(int i=bX; i<=aX;i++)
                q.add(new int[] {bY, i});
        }
        else {
            for(int i=bY;i<=aY;i++) {
                q.add(new int[] {i, bX});
            }
        }
    }
}