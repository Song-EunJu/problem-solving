// 테스트케이스는 맞지만 시간초과 나는 코드
import java.util.*;
import java.io.*;

class Node {
    int y;
    int x;
    int sec; // 퍼져나가는 한 단위마다 초를 늘려줘야 하기 때문에 second 값 저장

    public Node(int y, int x, int sec){
        this.y = y;
        this.x = x;
        this.sec = sec;
    }
}

public class Main {
    static int dy[] = {1, -1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static char fire[][];
    static boolean visited[][];
    static int N, M, K;
    static int min;
    static int tmpCount;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 테스트 수행횟수

        for(int test=0;test<T;test++){
            min = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            fire = new char[N+1][M+1];
            visited = new boolean[N+1][M+1];
            for(int i=1;i<=N;i++){
                String str = br.readLine();
                for(int j=1;j<=M;j++){
                    fire[i][j] = str.charAt(j-1);
                }
            }

            int minR, maxR, minC, maxC;
            minR = minC = Integer.MAX_VALUE;
            maxR = maxC = Integer.MIN_VALUE;

            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int R = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                fire[R][C] = '@';

                minR = minR > R ? R : minR;
                maxR = maxR < R ? R : maxR;
                minC = minC > C ? C : minC;
                maxC = maxC < C ? C : maxC;
            }

            // 인화물질이 떨어진 곳 최소 x,y좌표 / 최대 x,y좌표를 구해서 해당 범위만 검사
            for(int i=minR;i<=maxR;i++){
                for(int j=minC;j<=maxC;j++){
                    if(check(i, j)){
                        int second = bfs(i,j);
                        if(tmpCount == 0) // 모든 인화 물질을 제거했을 경우에만 second 최솟값 계산
                            min = Math.min(second, min);
                    }
                }
            }

            // 모든 인화 물질 제거 못한 경우 -1
            min = (min == Integer.MAX_VALUE) ? -1 : min;
            sb.append("#"+(test+1)+" "+min+"\n");
        }
        System.out.print(sb);
    }

    // 벽인지 체크
    public static boolean check(int y, int x){
        if(fire[y][x] == '#')
            return false;

        return true;
    }

    // 좌표가 배열 범위 내에 있는 지 확인
    public static boolean isIn(int posY, int posX){
        if(posY>=1 && posY<=N && posX>=1 && posX<=M)
            return true;
        return false;
    }

    // 방문 배열 초기화
    public static void fillArray(){
        for(boolean visit[] : visited)
            Arrays.fill(visit, false);
    }

    // 폭탄 개수 세서 count 배열에 넣어두고, '@' 에 닿을 때마다 count 개수를 줄이자.
    // 그리고 한턴 돌았는데 count 가 0이 안되면,
    public static int bfs(int y, int x){
        Deque<Node> q = new ArrayDeque<>();
        tmpCount = K;
        q.add(new Node(y, x, 0));
        visited[y][x] = true;

        int second = 0;
        while(!q.isEmpty()){
            if(second > min || tmpCount == 0){ // 이미 초가 min 값 보다 커졌거나, 인화물질을 모두 제거한 경우 break
                break;
            }
            Node node = q.poll();
            int curY = node.y;
            int curX = node.x;
            int curSec = second = node.sec;

            if(fire[curY][curX] == '@') // 인화물질에 소화제가 닿은 경우, 인화물질 개수 감소
                --tmpCount;

            for(int i=0;i<4;i++){
                int posY = curY + dy[i];
                int posX = curX + dx[i];

                // 범위에 포함되며, 벽이 아니고, 방문하지 않은 곳이면 큐에 추가
                if(isIn(posY, posX) && check(posY, posX) && visited[posY][posX] == false){
                    q.add(new Node(posY, posX, curSec+1));
                    visited[posY][posX] = true;
                    // 방문체크를 큐에서 꺼낼 때가 아니라, 큐에 추가할 때 해줘야 함
                    // 안그러면 중복 방문을 하게 된다.
                }
            }
        }
        fillArray();
        return second;
    }
}
