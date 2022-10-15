import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int cnt=0;
        int start=0, end=n-1;
        while(start<end){
            int startNum = arr[start];
            int endNum = arr[end];
            if(startNum+endNum==x){
                cnt++;
                end--;
            }
            else if(startNum+endNum<x){
                start++;
            }
            else end--;
        }
        System.out.println(cnt);
    }
}
