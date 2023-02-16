import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 요리사 {
    static int arr[][];
    static boolean visit[];
    static int N, min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int test=0;test<T;test++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N]; // 식재료 2차원 배열
            visit = new boolean[N]; // 식재료 N개를 2개로 나누기 위해서 t,f로 관리할 배열 => t끼리 한 집단, f끼리 한 집단
            min = Integer.MAX_VALUE;

            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            divide(0, 0);
            System.out.println("#"+(test+1)+" "+min);
        }
    }

    public static void divide(int num, int start) {
        if(num == N/2) { // n/2 개를 방문처리한 경우, 배열 원소 합계 차이 계산
            calcTaste();
            return;
        }

        for(int i=start;i<N;i++) { // for(int i=0; 부터 시작하고 if(visit[i]) continue; 로 하는 경우 시간초과 발생
            visit[i] = true;
            divide(num+1, i+1);
            visit[i] = false;
        }
    }

    private static void calcTaste() {
        int firstSum = 0;
        int secondSum = 0;
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(visit[i] && visit[j]) { // 그룹 1에 대한 합을 구하는 코드
                    firstSum+=arr[i][j]+arr[j][i];
                }
                else if(!visit[i] && !visit[j]) { // 그룹 2에 대한 합을 구하는 코드
                    secondSum+=arr[i][j]+arr[j][i];
                }
            }
        }
        min = Math.min(min, Math.abs(firstSum-secondSum));
    }
}