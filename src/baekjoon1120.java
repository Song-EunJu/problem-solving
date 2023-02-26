import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        int diff = 0;
        // 문자열의 길이가 같을 때는 그냥 차이 계산해야 함
        if(a.length() == b.length()){
            for(int i=0;i<a.length();i++){
                if(a.charAt(i) != b.charAt(i))
                    diff++;
            }
        }
        else { // 문자열 길이가 다를 때
            int frontDiff = 0, backDiff = 0;

            // b가 a를 포함하는 경우 차이 0
            if (b.contains(a)){
                System.out.println(0);
                return;
            }

            // 앞에서 비교
            for(int i=0;i<a.length();i++){
                if(a.charAt(i) != b.charAt(i))
                    frontDiff++;
            }

            // 뒤에서 비교
            int start = b.length()-a.length();
            for(int i=start;i<b.length();i++){
                if(a.charAt(i-start) != b.charAt(i))
                    backDiff++;
            }
            diff = Math.min(frontDiff, backDiff);

            // 가운데에서 일치하는 문자열은 아니지만, 차이가 적게 나는 문자열 찾기
            for(int i=0;i<=b.length()-a.length();i++){
                int middleDiff = 0;
                for(int j=i;j<i+a.length();j++){
                    if(a.charAt(j-i) != b.charAt(j))
                        middleDiff++;
                }
                diff = Math.min(diff, middleDiff);
            }
        }
        System.out.println(diff);
    }
}
