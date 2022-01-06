import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon10870 {
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(fibo(num));
    }
    public static int fibo(int a) {
        if (a == 0 || a==1)
           return a;
        else
            return fibo(a-1)+fibo(a-2);
        /** 거슬러 내려가면 fibo(0), fibo(1) 인 순간부터 return a 를 하면서 더할 수 있다 */
    }
}
