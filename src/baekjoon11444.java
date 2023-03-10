import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon11444 {
    static final int divider = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());
        System.out.println(fibo(N));
    }

    private static long fibo(long n) {
        if(n == 1 || n == 0)
            return n;

        return (fibo(n-1)%divider + fibo(n-2)%divider)%divider;
    }
}
