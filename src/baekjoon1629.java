import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1629 {
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        System.out.println(calc(A, B));
    }

    /*
    private static long calc(long a, long b) {
        if(b==1)
            return a%c;

        if(b%2==0)
            return (calc(a, b/2) * calc(a, b/2))%c;
        else
            return ((calc(a, b/2) * calc(a, b/2))%c * calc(a,1))%c;
    }*/

    // 위의 코드는 calc(a, b/2) 라는 동일한 작업을 하는데 여러 번 호출 하게 하므로 시간초과 발생
    private static long calc(long a, long b) {
        if(b==1)
            return a % c;

        long temp = calc(a, b/2) % c;

        if(b%2==0)
            return (temp * temp) % c;
        else
            return (((temp * temp)% c) * a) % c;
    }
}
