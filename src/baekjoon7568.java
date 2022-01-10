import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baekjoon7568 {
    public static void main(String []args) throws Exception {
        // 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int count = 0;
        int n = Integer.parseInt(br.readLine());
        int arr [][] =new int [n][2];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0]= Integer.parseInt(st.nextToken());
            arr[i][1]= Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]){
                    count++;
                }
            }
            sb.append((count+1)+" ");
            count=0;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}