package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2023 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int numbers[] = {2,3,5,7};

        // 첫번째 자릿수는 2,3,5,7만 가능
        for(int i=0;i<numbers.length;i++) {
            int n = numbers[i];
            prime(1, n);
        }
        System.out.println(sb);
    }
    public static void prime(int cnt, int sum) {
        if(cnt == N) {
            sb.append(sum+"\n");
            return;
        }

        // 기존 수*10 + 새로운 수를 더하면서 소수인지 판별
        for(int i=1;i<=9;i++) {
            if(check(sum*10+i))
                prime(cnt+1, sum*10+i);
        }
    }
    public static boolean check(int num) {
        for(int i=2;i*i<=num;i++)
            if(num%i==0)
                return false;
        return true;
    }
}