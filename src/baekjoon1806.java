import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 1;
        int sum = arr[0];
        int min = Integer.MAX_VALUE;
        while(end<n){
            if(sum >= s){
                min = Math.min(min, end-start);
                sum -= arr[start];
                start++;
            }
            else if(sum < s){
                sum += arr[end];
                end++;
            }
        }
        System.out.println(min);
    }
}
