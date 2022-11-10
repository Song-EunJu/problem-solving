/**
 * 왼,오 모두 양쪽 모두 거리 2이상 공간이 확보될 때 조망권 확보
 @return 조망권이 확보된 세대의 수를 반환
 자기자신 위치 기준 왼2, 오2 자리까지 뺀 거의 최솟값 대신 0보다 커야 함 그경우에만 조망권 확보한 것
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<10; i++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arr[] = new int[N];
            for(int j=0;j<N;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int sum = 0;
            for(int j=2;j<N-2;j++){
                int min = Integer.MAX_VALUE;
                int a = arr[j]-arr[j-2];
                int b = arr[j]-arr[j-1];
                int c = arr[j]-arr[j+1];
                int d = arr[j]-arr[j+2];

                if(a>=0 && b>=0 && c>=0 && d>=0){
                    min = Math.min(d, Math.min(c, Math.min(b, Math.min(min,a))));
                    sum+=min;
                }
            }
            sb.append("#"+(i+1)+" "+sum+"\n");
        }
        System.out.println(sb);
    }
}
