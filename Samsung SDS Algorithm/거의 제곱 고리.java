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
            int N = Integer.parseInt(br.readLine()); // 서로 다른 숫자

            // 모든 배열의 길이는 5, 실제 데이터 개수는 4

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

        for(int i=1;i<arr.length;i++){ // i=num 으로 하면, 방문하지 못한 지점인데도 놓치게 됨
            if(visited[i] == false){ // 방문하지 않은 경우
                number[num] = arr[i]; // number[i] = arr[i] 이렇게 하면 i 값이 계속 바뀌므로 바꾸고 싶은 자리를 못 바꿈
                visited[i] = true; // visited[num] 으로 하면, 특정 자리만 바꾸게 되니까 바꾸고자 하는 i 값으로 바꿔야 함
                dfs(arr, num+1);
                visited[i] = false;
            }
        }
    }
}
 