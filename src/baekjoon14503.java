import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon14503 {
    static int arr[][];
    static boolean visited[][];
    static int cnt = 0; // 청소한 구역 체크하는 변수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cleanUp(startY, startX, d);
        System.out.println(cnt);
    }

    public static boolean checkStatus(int y, int x){
        int check = 0;
        // 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우 true
        // == 청소되었거나, 벽이거나 (모든 4칸이)
        if(arr[y-1][x] == 1 || visited[y-1][x] == true) // 벽이거나, 방문한 경우
            check++;

        if(arr[y+1][x] == 1 || visited[y+1][x] == true)
            check++;

        if(arr[y][x-1] == 1 || visited[y][x-1] == true)
            check++;

        if(arr[y][x+1] == 1 || visited[y][x+1] == true)
            check++;

        if(check == 4)
            return true;
        else
            return false;
    }

    // 바라보는 방향 기준으로, 뒤쪽 방향도 벽인 경우 체크
    // 0-북 / 1-동 / 2-남 / 3-서
    public static boolean checkBack(int y, int x, int d){
        if(d == 0 && arr[y+1][x] == 1)
            return true;
        if(d == 1 && arr[y][x-1] == 1)
            return true;
        if(d == 2 && arr[y-1][x] == 1)
            return true;
        if(d == 3 && arr[y][x+1] == 1)
            return true;
        return false;
    }

    public static void cleanUp(int y, int x, int d){
        if(visited[y][x] == false) { // 2-2번에서 다시 현 위치 기준으로 탐색을 진행할 때 또 cnt를 체크하지 않기 위해서
            visited[y][x] = true; // 현재 위치를 청소한다.
            cnt++;
        }

        if(checkStatus(y, x)){ // 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우 true
            if(checkBack(y, x, d)) // 뒤쪽 벽이 후진할수도 없는 경우
                return;

            // 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
            if(d == 0)
                cleanUp(y+1, x, d);
            else if(d == 1)
                cleanUp(y, x-1, d);
            else if(d == 2)
                cleanUp(y-1, x, d);
            else if(d == 3)
                cleanUp(y, x+1, d);
        }
        else{ // 청소되지 않은 빈칸이 있는 경우
            if(d == 0 && arr[y][x-1] != 1 && visited[y][x-1] == false) { // 벽이 아닌데
                d = 3; // 북쪾기준 왼쪽은 서쪽 방향으로 회전하고
                cleanUp(y, x-1, d); // 한칸 전진
            }
            else if(d == 1 && arr[y-1][x] != 1 && visited[y-1][x] == false){
                d = 0;// 동쪽 기준 왼쪽은 북쪽
                cleanUp(y-1, x, d);
            }
            else if(d == 2 && arr[y][x+1] != 1 && visited[y][x+1] == false){
                d = 1; // 남쪽 기준 왼쪽은 동쪽
                cleanUp(y, x+1, d);
            }
            else if (d == 3 && arr[y+1][x] != 1 && visited[y+1][x] == false) {
                d = 2; // 서쪽 기준 왼쪽은 남쪽
                cleanUp(y+1, x, d);
            }
        }
    }
}
