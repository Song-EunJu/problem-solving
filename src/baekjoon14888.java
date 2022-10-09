import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 이해]
 * - 수의 순서 변경 불가
 * - 식의 계산은 앞에서 부터 진행
 * - 식의 결과가 최대, 최소인 것 구하기
 * */
public class baekjoon14888 {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int number[] = new int[n];
        int op[] = new int[4]; // 사용할 수 있는 연산자 배열

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        dfs(number[0], idx, number, op);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int sum, int idx, int[] number, int[] op){
        if(idx == number.length-1) { // 연산자의 개수는 숫자보다 하나 작으니까
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }

        /**
         * op의 배열 값을 줄여가면서 (하나씩 사용해가면서) 연산자 빈자리를 채워 계산하는 것
         * 이게 a,b 순서로 계산했다가 b,a 로 어케 가나했더니
         * (1010) -> (0010) -> (0000) -> (0010) -> (1010) 까지 한번 연산 돌고
         * (1010) -> (1000) -> (0000) -> (1000) -> (1010) 이렇게 옴
        */
        for(int i=0;i<op.length;i++){
            if(op[i]!=0){
                op[i]--;
                switch(i){
                    case 0:
                        dfs(sum+number[idx+1], idx+1, number, op);
                        break;
                    case 1:
                        dfs(sum-number[idx+1], idx+1, number, op);
                        break;
                    case 2:
                        dfs(sum*number[idx+1], idx+1, number, op);
                        break;
                    case 3:
                        dfs(sum/number[idx+1], idx+1, number, op);
                        break;
                }
                op[i]++;
            }
        }
    }
}
