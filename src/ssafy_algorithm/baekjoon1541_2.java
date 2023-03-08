package ssafy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon1541_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split("-");
        int sum = 0;
        for(int i=0;i<s.length;i++){
            if(s[i].contains("+")){ // 더하기 연산 해야 하는 경우
                String plus[] = s[i].split("\\+");
                int plusSum = 0;
                for(String plusStr: plus){
                    plusSum += Integer.parseInt(plusStr);
                }
                sum = (i==0) ? plusSum : sum - plusSum;
            }
            else // 그냥 빼는 경우
                sum = (i==0) ? Integer.parseInt(s[i]) : sum-Integer.parseInt(s[i]);
        }
        System.out.println(sum);
    }
}
