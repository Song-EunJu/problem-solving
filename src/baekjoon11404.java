import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int arr[][] = new int[n+1][n+1];

        // 일단 무한대로 초기화 해두고~
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                arr[i][j] = 20000000; // 100개의 도시 * 10000 거리 = 10,000,000 은 넘어야 함
            }
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(arr[a][b] !=0)
                arr[a][b]= Math.min(arr[a][b],c);
            arr[a][a]=0;
        }


        for(int i=1;i<=n;i++){ // 시작점
            for(int j=1;j<=n;j++){ // 도착점
                for(int k=1;k<=n;k++){
                    if(arr[i][k]+arr[k][j]<arr[i][j]){
                        // MAX_VALUE 로 초기화했다가는 더했을 때 overflow 나서 (-) 나올 수 있음
                        arr[i][j] = arr[i][k]+arr[k][j];
                    }
                }
            }
        }

        for(int i=1;i<=n;i++){ // 시작점
            for(int j=1;j<=n;j++){ // 도착점
                for(int k=1;k<=n;k++){
                    if(arr[i][k]+arr[k][j]<arr[i][j]){
                        // MAX_VALUE 로 초기화했다가는 더했을 때 overflow 나서 (-) 나올 수 있음
                        arr[i][j] = arr[i][k]+arr[k][j];
                    }
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(arr[i][j]==20000000)
                    System.out.print(0+" ");
                else System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}
