import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test {
    static int startY;
    static int startX;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {-1, 1, 0, 0};
    static boolean visited[][];
    static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i=0;i<10;i++){
            arr = new int[16][16];
            visited = new boolean[16][16];
            int num = Integer.parseInt(br.readLine());
            for(int j=0;j<16;j++) {
                String s = br.readLine();
                for(int k=0;k<16;k++){
                    arr[j][k] = s.charAt(k)-'0';
                    if(arr[j][k] == 2){
                        startY = j;
                        startX = k;
                    }
                }
            }
            System.out.println("#"+num+" "+bfs(startY, startX));
        }
    }
    public static int bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});

        while(!q.isEmpty()){
            int[] xy = q.poll();
            int nowY = xy[0];
            int nowX = xy[1];
            visited[nowY][nowX] = true;

            if(arr[nowY][nowX] == 3)
                return 1;

            for(int i=0;i<4;i++){
                int posY = nowY + dy[i];
                int posX = nowX + dx[i];

                if(posY >=0 && posY <= 15 && posX >=0 && posX <= 15 && visited[posY][posX] == false && arr[posY][posX] !=1){
                    q.add(new int[] {posY, posX});
                }
            }
        }
        return 0;
    }
}
