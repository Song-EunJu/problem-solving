import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int arr[] = new int[n+1];
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i+1] = arr[i] + Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(arr[end]-arr[start-1]+"\n");
        }
        System.out.println(sb);
    }
}
