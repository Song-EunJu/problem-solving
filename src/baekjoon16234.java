import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pos {
    int y;
    int x;

    Pos(int y, int x){
        this.y = y;
        this.x = x;
    }
}
public class baekjoon16234 {
    static int N, L, R;
    static int arr[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static boolean visit[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt=0;
        while(true){
            visit = new boolean[N][N]; // 재분배한번 끝나고 나서

            List<List<Pos>> list = new ArrayList<>();
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(visit[i][j]==false) {
                        List<Pos> posList = bfs(i, j);
                        if(posList.size() != 1)
                            list.add(posList);
                    }
                }
            }

            if(list.size() == 0) // 인구변화가 없는 경우 중단
                break;

            // 국경선이 모두 열린 경우 인구이동 시작
            redistribution(list);

            cnt++;
        }
        System.out.println(cnt);
    }

    public static List<Pos> bfs(int y, int x){
        List<Pos> list = new ArrayList<>(); // 한 국가에서 연결된 모든 국가들의 좌표를 담는 리스트
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(y,x));

        while(!q.isEmpty()) {
            Pos now = q.poll();
            int nowY = now.y;
            int nowX = now.x;
            if(visit[nowY][nowX] == true)
                continue;
            visit[nowY][nowX] = true;
            list.add(now);

            for (int i = 0; i < 4; i++) {
                int posY = nowY + dy[i];
                int posX = nowX + dx[i];

                if (posY >= 0 && posY < N && posX >= 0 && posX < N) {
                    int diff = Math.abs(arr[nowY][nowX] - arr[posY][posX]);
                    if ((L <= diff && diff <= R) && visit[posY][posX]==false) { // 두 나라의 인구 차이가 범위 내에 들어간다면 해당 인접국가도 큐에 넣음
                        q.add(new Pos(posY, posX));
                    }
                }
            }
        }
        return list;
    }

    public static void redistribution(List<List<Pos>> list){
        for(int i=0;i<list.size();i++){ // 연합인구 그룹이 몇개인지
            int sum = 0;
            List<Pos> population = list.get(i); // 해당 그룹 내의 국가가 몇개인지
            for(int j=0;j<population.size();j++){
                int y = population.get(j).y;
                int x = population.get(j).x;
                sum += arr[y][x];
            }

            int divide = sum/population.size();
            for(int j=0;j<population.size();j++){
                int y = population.get(j).y;
                int x = population.get(j).x;
                arr[y][x] = divide;
            }
        }
    }
}
