import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        Integer B[] = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            B[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A); // 오름차순
        Arrays.sort(B, (o1, o2) -> o2-o1); // 내림차순
        /** 다른 건 모르겠고, B의 최댓값에는 A의 최솟값과 매칭시키는게 최선의 선택 -> 그리디 */

        int sum = 0;
        for(int i=0;i<N;i++){
            sum += A[i] * B[i];
        }
        System.out.println(sum);

    }
}
