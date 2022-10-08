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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int number[] = new int[n];
        int op[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        calculate(number, op);
    }
    public static void calculate(int number[], int op[]){
        int sum = number[0];
        for(int i=1;i<number.length;i++) {
            int nextNum = number[i];

            switch(nextNum){
                case 0:
                    sum += nextNum;
                    break;
                case 1:
                    sum -= nextNum;
                    break;
                case 2:
                    sum *= nextNum;
                    break;
                case 3:
                    sum /= nextNum;
                    break;
            }


        }

    }
}
