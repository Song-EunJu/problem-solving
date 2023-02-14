import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        visit = new boolean[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt=0;
        while(cnt<9){
            int impossible = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    List<int[]> list = bfs(i,j);
                    if(!list.isEmpty()) // 인구 이동이 가능한 경우
                        redistribution(list);
                    else // 인구 이동이 불가능한 경우
                        impossible++;
                }
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            cnt++;
        }
        System.out.println(cnt);
    }

    public static List<int[]> bfs(int y, int x){
        List<int[]> list = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});

        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowY = now[0];
            int nowX = now[1];
            list.add(new int[]{nowY, nowX});
            visit[nowY][nowX] = true;

            for(int i=0;i<4;i++) {
                int posY = nowY + dy[i];
                int posX = nowX + dx[i];
                if(posY >= 0 && posY < N && posX >= 0 && posX < N && !visit[posY][posX]) {
                    // 범위에도 들어가고, 방문하지 않은 경우
                    int diff = Math.abs(arr[nowY][nowX] - arr[posY][posX]);
                    if(L<=diff && diff<=R) { // 두 나라의 인구 차이가 범위 내에 들어간다면
                        q.add(new int[]{posY, posX});
                    }
                }
            }
        }
        return list;
//        System.out.println("#####"+y+" "+x);
//        for(int i=0;i<list.size();i++){
//            System.out.print(arr[list.get(i)[0]][list.get(i)[1]]+" ");
//        }
//        System.out.println();
    }

    public static void redistribution(List<int[]> list){
        int sum = 0;
        for(int i=0;i<list.size();i++){
            int y = list.get(i)[0];
            int x = list.get(i)[1];
            sum += arr[y][x];
        }
        int divide = sum/list.size();
        for(int i=0;i<list.size();i++) {
            int y = list.get(i)[0];
            int x = list.get(i)[1];
            arr[y][x] = divide;
        }
    }
}
