import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon12891 {
    static int alphabet[];
    static int aCnt, cCnt, gCnt, tCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
        String s = br.readLine();
        st = new StringTokenizer(br.readLine());
        aCnt = Integer.parseInt(st.nextToken());
        cCnt = Integer.parseInt(st.nextToken());
        gCnt = Integer.parseInt(st.nextToken());
        tCnt = Integer.parseInt(st.nextToken());

        int start=0;
        alphabet = new int[26];
        for(int i=0;i<S;i++) {
            alphabet[s.charAt(i)-65]++; // 반복문을 돌면서 알파벳 개수 계산
            if(i>=P-1) { //  부분문자열 길이가 충족된 경우부터 알파벳 개수 체크 로직 동작
                if(checkNum())
                    result++;
                alphabet[s.charAt(start)-65]--; // 부분문자열의 맨 처음인덱스에 해당하는 알파벳 개수를 줄이고
                start++; // 시작 위치를 1 증가시켜줌
            }
        } // 즉, start=문자열의 시작위치 / i=문자열의 끝 위치
        System.out.println(result);
    }

    public static boolean checkNum() {
        // 부분문자열에 포함된 개수가 조건에서 주어진 알파벳 개수보다 많은 지 체크
        if(aCnt<=alphabet['A'-65] && cCnt<=alphabet['C'-65]
                && gCnt<=alphabet['G'-65] && tCnt<=alphabet['T'-65])
            return true;
        return false;
    }
}