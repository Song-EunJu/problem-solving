// 평탄화 작업을 위한 작업횟수에 제한.
// 가장 높은 곳에서 가장 낮은 곳으로 옮겨야 함
// 제한된 횟수만큼 옮긴 후의 최고점-최저점의 차이 반환
// 평탄화를 모두 수행하면, 최고점-최저점<=1 이 된다.
// 주어진 덤프 횟수 이내에 평탄화가 완료되면, 더이상 덤프 수행불가능하니까

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<10;i++){
            int dump = Integer.parseInt(br.readLine());
            int arr[] = new int[100];
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<100;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for(int j=0;j<dump;j++){
                Arrays.sort(arr);
                arr[0]++;
                arr[arr.length-1]--;
            }
            Arrays.sort(arr);
            sb.append("#"+(i+1)+" "+(arr[arr.length-1]-arr[0])+"\n");
        }
        System.out.println(sb);
    }
}
