import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2747 {
    static int memo[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n+1];
        System.out.println(fibo(n));
    }

    private static int fibo(int n) {
        if(n==0 || n==1) {
            return n;
        }
        else if(memo[n] != 0){
            return memo[n];
        }
        else
            return memo[n] = fibo(n-1) + fibo(n-2);
    }
}
