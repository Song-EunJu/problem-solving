import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정사각형방 {
    static int dy[] = {1, -1, 0, 0};
    static int dx[] = {0, 0, 1, -1};
    static int N;
    static int arr[][];
    static boolean visit[][];
    static int cnt;
    public static void main(String[] args) throws IOException {
        // 어떤 수가 적힌 방에 있어야 가장 많은 개수의 방을 이동할 수 있는가?
        // dfs
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int element =  Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for(int i=0;i<N;i++) {
                for (int j=0;j<N;j++) {
                    cnt = 1;
                    visit = new boolean[N][N];
                    int result = dfs(i, j);
                    if(result > max){
                        max = result;
                        element = arr[i][j];
                    }
                    else if(result == max){
                        if(element > arr[i][j])
                            element = arr[i][j];
                    }
                }
            }
            System.out.println("#"+(t+1)+" "+element+" "+max);
        }
    }

    public static int dfs(int y, int x){
        visit[y][x] = true;
        for(int i=0;i<4;i++){
            int posY = y + dy[i];
            int posX = x + dx[i];
            if(inRange(posY, posX) && arr[posY][posX]-arr[y][x]==1 && !visit[posY][posX]) {
                cnt++;
                dfs(posY, posX);
            }
        }
        return cnt;
    }

    private static boolean inRange(int posY, int posX) {
        if(posY>=0 && posY<N && posX>=0 && posX<N)
            return true;
        return false;
    }
}
