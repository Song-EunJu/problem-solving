import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 기존 코드 : 시작점, 도착점, 거쳐가는 지점 이 순서대로 삼중 for문을 구성했음
 * 기존 코드에서는 (3,2) 의 최단 거리를 구할 때
 * (3,1) (1,2)
 * ...
 * (3,5) (5,2) 이런식으로 가는데 i=3일 때 (5,2) 가 최단거리임이 보장되지 않은 상태인데
 * (3,2) 의 거리를 더이상 갱신하지 않게 된다.
 *
 * 따라서 거쳐가는 지점, 시작점, 도착점 이 순서대로 코드 변경
 * (3,5) (5,1)
 * ...
 * (3,5) (5,2) 이런식으로 가는데 (5,2) 는 이미 i=5 일 때 (5,1) (1,2) 이렇게 계산하고 왓음
 * 따라서 거쳐가는 지점을 고정으로 두고 시작점과 도착점을 바꿔가면서 갱신하게 되면 최단거리를 보장하게 됨
 * (5,2) = (5,1) (1,2)
 *       = (5,2) (2,2)
 *       = (5,3) (3,2)
 *       = (5,4) (4,2)
 * */
public class baekjoon11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int arr[][] = new int[n+1][n+1];

        // 일단 무한대로 초기화 해두고~
        for(int i=1;i<=n;i++){
            Arrays.fill(arr[i], 20000000); // 100개의 도시 * 10000 거리 = 10,000,000 은 넘어야 함
            arr[i][i]=0;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(arr[a][b] !=0)
                arr[a][b]= Math.min(arr[a][b],c);
        }

        for(int k=1;k<=n;k++){ // 거쳐가는 지점
            for(int i=1;i<=n;i++){ // 시작점
                for(int j=1;j<=n;j++){ // 도착점
                    arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(arr[i][j]>=20000000)
                    sb.append(0+" ");
                else sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
