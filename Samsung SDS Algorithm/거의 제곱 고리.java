// 원순열을 배열 0번째 열에 마지막 원소 값을 채워넣는 것으로 구현

import java.util.*;
import java.io.*;
public class Main {
    static int number[];
    static boolean visited[];
    static int max;
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 테스트 수행횟수
        for(int i=0;i<T;i++){
            max = Integer.MIN_VALUE;
            int N = Integer.parseInt(br.readLine());

            int arr[] = new int[N+1]; // 첫칸을 맨마지막 요소로 채우기 위해서 N+1로 초기화

            number = new int[N+1];
            visited = new boolean[N+1];

            st = new StringTokenizer(br.readLine());

            for(int j=1;j<=N;j++)
                arr[j] = Integer.parseInt(st.nextToken()); // (null,1,3,6,8)

            number[1] = arr[1]; // number = [null, 1, null, null, null]
            visited[1] = true;
            dfs(arr, 2);
            sb.append("#"+(i+1)+" "+max+"\n");
        }
        System.out.print(sb.toString());
    }

    public static void dfs(int[] arr, int num) {
        if(num == arr.length){
            count = 0;
            // 마지막 원소를 처음에 넣고 계산 시작
            number[0] = number[arr.length-1];
            for(int i=0;i<arr.length-1;i++){
                Double n = Math.sqrt(number[i]+number[i+1]);
                if(n.intValue() == n)
                    count++;
            }
            max = Math.max(count, max);
            return;
        }

        for(int i=1;i<arr.length;i++){
            if(visited[i] == false){ // 방문하지 않은 경우
                number[num] = arr[i];
                visited[i] = true;
                dfs(arr, num+1);
                visited[i] = false;
            }
        }
    }
}
