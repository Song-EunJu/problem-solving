import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon15686_2 {
    static List<int[]> chickens;
    static int N, M;
    static int dy[] = {1, -1, 0, 0};
    static int dx[] = {0, 0, 1, -1};
    static int city[][];
    static boolean visit[][];
    static int min;
    public static void main(String[] args) throws IOException {
        // 치킨 거리 : 집과 가장 가까운 치킨집 사이의 거리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 폐업시키지 않을 치킨집
        city = new int[N][N];
        chickens = new ArrayList<>();
        min = Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 2)
                    chickens.add(new int[]{i,j});
                city[i][j] = num;
            }
        }

        combination(0, 0);
        System.out.println(min);
    }

    // cnt : 폐업 시킬 치킨집
    public static void combination(int cnt, int start){
        if(cnt == chickens.size()-M){ // 폐업시킬 치킨집 (list.size()-M)개
            int sum = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(city[i][j] == 1) {
                        visit = new boolean[N][N];
                        sum += bfs(i, j);
                        if(sum > min){ // 이미 sum 이 최솟값보다 커진 경우
                            return;
                        }
                    }
                }
            }
            min = Math.min(min, sum); // 도시의 치킨 거리가 가장 작게 되는 경우
            return;
        }

        for(int i=start;i<chickens.size();i++){ // 치킨집 방문 체크하면서
            int y = chickens.get(i)[0];
            int x = chickens.get(i)[1];
            city[y][x] = 0;
            combination(cnt+1, i+1);
            city[y][x] = 2;
        }
    }

    public static int bfs(int y, int x){
        Queue<int[]> q = new LinkedList <>();
        q.add(new int[]{y, x});
        visit[y][x] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowY = now[0];
            int nowX = now[1];

            for(int i=0;i<4;i++){
                int posY = nowY + dy[i];
                int posX = nowX + dx[i];
                if(posY>=0 && posY<N && posX>=0 && posX<N && !visit[posY][posX]) {
                    if (city[posY][posX] == 2) {// 치킨 집인 경우 해당 집과의 치킨 거리 구하기
                        return Math.abs(posY - y) + Math.abs(posX - x);
                    }
                    else {
                        q.add(new int[]{posY, posX});
                        visit[posY][posX] = true;
                    }
                }
            }
        }
        return 0;
    }
}
