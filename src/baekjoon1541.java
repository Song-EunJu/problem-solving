import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 가장 작은 수를 구하기 위해서는 (-) 연산자를 계속 사용해야 함.
 * 즉, + 가 나온 경우 주변의 것을 다 더한 후 최종으로 - 연산을 함
 */
public class baekjoon1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // 일단 이 숫자들을 배열 하나에 한데 모음
        String[] minus = str.split("-"); // 마이너스 기준으로 자른 배열
        int sum = 0;
        for(int i=0;i<minus.length;i++){
            int plusSum = 0;
            if(minus[i].contains("+")) {// +를 가지고 있는 경우
                String[] plus = minus[i].split("\\+");
                for(int j=0;j<plus.length;j++){
                    plusSum += Integer.parseInt(plus[j]);
                }
            }
            if(i==0) // 첫번째 토큰인데 + 가 안들어가있으면 원소 하나만 더함
                sum = (plusSum == 0 ? Integer.parseInt(minus[i]) : plusSum);
            else // 그 이후부터는 계산한 값을 sum에서 빼줌
                sum -= ((plusSum == 0) ? Integer.parseInt(minus[i]) : plusSum);
        }
        System.out.println(sum);
    }
}
