import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon11444 {
    public static void main(String[] args) throws IOException {
        long a = 1;
        // 분할 정복 ? 작은 문제로 분할하고 합치는거 아닌가
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());
        System.out.println(fibo(N));
    }

    private static long fibo(long n) {
        if(n == 1 || n == 0){
            return n;
        }
        return (fibo(n-1)%1000000007 + fibo(n-2)%1000000007)%1000000007;
    }
}
