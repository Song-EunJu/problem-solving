import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class baekjoon1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int arr[][] = new int[n][2];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
            sb.append(cal(arr[i][0], arr[i][1])+"\n");
        }
        System.out.println(sb.toString());
    }

    static BigInteger cal(int west, int east){
        BigInteger sum = factorial(east).divide(factorial(east-west)).divide(factorial(west));
        return sum;
    }

    /**
     * BigInteger 는 문자열을 인자로 넘겨주어야 함
     * 문자열이기 때문에 BigInteger 내부의 메소드로 사칙연산 가능
     */
    static BigInteger factorial(int n){
        if(n==1 || n==0)
            return new BigInteger(String.valueOf(1));
        else{
            return new BigInteger(String.valueOf(n)).multiply(new BigInteger(String.valueOf(factorial(n-1))));
        }
    }
}