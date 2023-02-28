import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2567 {
    static int arr[][];
    public static void fillArray(int x, int y) {
        for(int i=y;i<y+10;i++) { // 7
            for(int j=x;j<x+10;j++) { // 3
                arr[i][j] = 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        /**(100,100) 으로 선언했을 때 (90, 90) 지점이 계산이 안됨 */
        arr = new int[101][101];
        StringTokenizer st;
        for(int t=0;t<T;t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 3
            int y = Integer.parseInt(st.nextToken()); // 7
            fillArray(x, y);
        }

        int answer = 0;
        int dy[] = {1,-1,0,0};
        int dx[] = {0,0,1,-1};

        for(int i=0;i<101;i++) {
            for(int j=0;j<101;j++) {
                if(arr[i][j] == 1) {
                    int cnt = 0;

                    for(int k=0;k<4;k++) {
                        int posY = i+dy[k];
                        int posX = j+dx[k];

                        if(posY<0 || posY>100 || posX<0 || posX>100)
                            continue;

                        if(arr[posY][posX] == 0)
                            cnt++;
                    }

                    // 주변에 0인 애가 2개인 경우
                    if(cnt==2)
                        answer+=2;
                    else if(cnt==1)
                        answer++;
                }
            }
        }
        System.out.println(answer);
    }
}