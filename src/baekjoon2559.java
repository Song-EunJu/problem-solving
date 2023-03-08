import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연속된 온도의 합이 최대가 된다..
 * 누적합을 구한 다음에, 해당 인덱스 전까지의 합을 빼버려서 최댓값을 구해보자 */
public class baekjoon2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++)
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        max = Math.max(max, arr[K-1]);
        for (int i=0;i<N-K;i++){
            max = Math.max(max, arr[i+K]-arr[i]);
        }
        System.out.println(max);
    }
}
