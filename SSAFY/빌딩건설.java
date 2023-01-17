import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ssafy {
    static int dy[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int dx[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int N;
    static char arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k=0;k<T;k++){
            int max = Integer.MIN_VALUE;
            N = Integer.parseInt(br.readLine());
            arr = new char[N][N];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    arr[i][j] = st.nextToken().charAt(0);
                }
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(isNearByG(i,j)){ // 인접구획에 G구역이 있다면
                        max = Math.max(max, 2);
                    } else { // G구역이 없다면
                        max = Math.max(max, sumBbuilding(i, j));
                    }
                }
            }
            System.out.println("#"+(k+1)+" "+max);
        }
    }

    public static boolean isNearByG(int y, int x){
        for(int i=0;i<8;i++){
            int posY = y+dy[i];
            int posX = x+dx[i];
            if(posY>=0 && posY<N && posX>=0 && posX<N) // 범위 안에 들어가면
                if(arr[posY][posX]=='G')
                    return true;
        }
        return false;
    }

    public static int sumBbuilding(int y, int x){
        int b=0;
        for(int i=0;i<N;i++){
            if(arr[y][i] == 'B')
                b++;
            if(arr[i][x] == 'B')
                b++;
        }
        return b-1;
    }
}
