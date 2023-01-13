import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 회사에서 출발하여 N명의 고객을 모두 방문하고 집으로 돌아오는 경로 중 가장 짧은 것만 찾으면 됨
/**
 * [완전탐색]
 *
 * 1. 회사, 집 좌표 따로 저장
 * 2. 고객들의 좌표를 배열에 저장 + 해당 배열에 방문여부까지 체크하는 변수 존재
 * 3. dfs 를 통해 배열 나열하는 경우의 수를 모두 따짐
 * ++ 이동할 때마다 거리체크한 거를 같이 sum 값으로 넘기면 됨
 *
 * */
class Pos {
    int y;
    int x;

    public Pos(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
public class test {
    static Pos company;
    static Pos house;
    static int N;
    static int min;
    static Pos[] customers;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++){
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            customers = new Pos[N];
            visited = new boolean[N];
            int inputs[] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            company = new Pos(inputs[0], inputs[1]);
            house = new Pos(inputs[2], inputs[3]);

            int k = 4;
            // 고객 좌표 저장
            for(int j=4;j<4+N;j++) {
                customers[j-4] = new Pos(inputs[k], inputs[k+1]);
                k+=2;
            }
            dfs(company.y, company.x, 0, 0); // 회사에서 출발하는 거리 계산하기
            System.out.println("#"+(i+1)+" "+min);
        }
    }
    public static void dfs(int posY, int posX, int sum, int num){
        if(num == N){
            // 회사와 집 간의 거리만 더해줌
            sum += getDistance(posY, house.y, posX, house.x);
            min = Math.min(min, sum);
            return ;
        }

        for(int i=0;i<N;i++){ // i=idx 이렇게 해버리면, 0부터 다시 방문하는 경우가 빠지게 되니까
            if(!visited[i]){ // 방문하지 않은 곳만 처리
                visited[i] = true;
                int nowY = customers[i].y;
                int nowX = customers[i].x;
                dfs(nowY, nowX,sum + getDistance(posY, nowY, posX, nowX), num+1);
                visited[i] = false;
            }
        }
    }

    public static int getDistance(int y1, int y2, int x1, int x2){
        return Math.abs(y1-y2) + Math.abs(x1-x2);
    }
}
