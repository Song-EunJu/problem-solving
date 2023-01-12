import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 마주보는 숫자를 모두 곱한 뒤 더했을 때의 최댓값
public class tt2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int arr1[] = new int[N];
            int arr2[] = new int[M];

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr1[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr2[j] = Integer.parseInt(st.nextToken());
            }

            int maxLen = Math.max(arr1.length, arr2.length);
            int minLen = Math.min(arr1.length, arr2.length);

            int max = Integer.MIN_VALUE;
            for(int j=0;j<maxLen-minLen+1;j++){
                int sum = 0;
                for(int k=j;k<j+minLen;k++){
                    if(arr1.length == maxLen) // arr1 이 큰 배열인 경우
                        sum += arr1[k] * arr2[k-j];
                    else
                        sum += arr1[k-j] * arr2[k];
                }
                max = Math.max(max, sum);
            }
            System.out.println("#"+(i+1)+" "+max);
        }
    }
}