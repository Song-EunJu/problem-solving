import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * - 숫자를 입력받고, 이 숫자를 재조합해서 30의 배수로 만들기
 * - N의 최댓값이 10^5 이니까 최대가 (10^5)! 임.
 *
 * - 30의 배수인 경우, 무조건 0으로 끝나야 함
 * - 0으로 끝나는 거 앞은 무조건 3의 배수여야 함
 * - 3의 배수는 각 자릿수의 합이 3의 배수여야 함
 * - 그러면 0으로 끝나는 거 앞자리를 정렬한 다음에 다 더해서 3의 배수인지 확인하면 되지 않을까
 * */
public class baekjoon10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] strs = str.split("");
        Arrays.sort(strs, Collections.reverseOrder());

        if(strs[str.length()-1].charAt(0) != '0')
            System.out.println(-1);
        else {
            long sum = 0;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<str.length();i++) {
                char ch = strs[i].charAt(0);
                sb.append(ch);
                sum += ch;
            }
            System.out.println(sum%3 == 0 ? sb : -1);
        }
    }
}
