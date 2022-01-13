import java.io.*;
import java.util.*;

public class baekjoon11399 {
    // 그리디 알고리즘 : 당장의 최적 상황만을 쫓아 최종 해답에 도달하는 방법
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 작은 수부터 정렬해서 하나씩 더하기 위해서 3 1 4 3 2 -> 1 2 3 3 4
        int total=0;
        int sum=0;
        for(int i=0;i<n;i++){
            total+=arr[i];
            sum+=total;
        }
        System.out.println(sum);
    }
}
