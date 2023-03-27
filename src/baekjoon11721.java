import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int start=0;
        int end = 0;
        while(end < str.length()){
            if(start+10 > str.length()) // start 지점에 10 더한게 문자열 길이보다 큰 경우
                end = str.length(); // end를 문자열 길이 끝 지점으로 세팅
            else // start 지점이 문자열 길이보다 작다면 10자리까지 출력
                end+=10;
            System.out.println(str.substring(start, end));
            start = end; // 시작 지점이 end 로 바껴야 함
        }
    }
}
