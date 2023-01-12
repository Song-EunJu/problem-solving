import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 마주보는 숫자를 모두 곱한 뒤 더했을 때의 최댓값
public class tt2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            int N = Integer.parseInt(br.readLine());
            int arr[][] = new int[N][N];
            for(int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<N;k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("#"+(i+1));
            for(int j=0;j<N;j++){
                for(int k=N-1;k>=0;k--){
                    System.out.print(arr[k][j]);
                }
                System.out.print(" ");
                for(int k=N-1;k>=0;k--){
                    System.out.print(arr[N-1-j][k]);
                }
                System.out.print(" ");
                for(int k=0;k<N;k++){
                    System.out.print(arr[k][N-1-j]);
                }
                System.out.println();
            }
        }
    }
}
