/*
 중복되는 부분을 몇글자씩 잘라야 최소인가..
 -> 한 글자~n글자까지 다 잘라봐야 하는가..

 스택? -> 문자열 다 들어오는 거 보고 해야 패턴이 보일듯
 패턴? -> 정규식 써야 하나
 문자열 내에서 중복된 문자열이 있는지 확인하기
*/
import java.util.*;
class Solution {
    public int solution(String s) {
        int min = Integer.MAX_VALUE;

        // 글자수가 1인 경우
        if(s.length() == 1)
            return 1;

        for(int i=s.length()/2;i>=1;i--){ // 8
            int divideChar = i; // 나눌 글자 수
            String[] str;

            if(s.length()%i==0) // 나누어 떨어지면 그만큼만 배열 크기 지정
                str = new String[s.length()/i];
            else
                str = new String[s.length()/i+1];

            // 배열에 나눌 글자 수만큼 잘라서 문자열을 넣음
            for(int j=0;j<str.length;j++){
                str[j] = (j*divideChar+divideChar>=s.length())
                        ? s.substring(j*divideChar, s.length())
                        : s.substring(j*divideChar, j*divideChar+divideChar);
            }

            // s 문자열에서 압축할 문자열이 있는지 확인
            Set<String> set = new HashSet<>();
            for(int j=0;j<str.length;j++){
                set.add(str[j]); // abcabc, abcabc, dedede, dedede
            }

            // 문자열 배열과 set의 크기가 동일하다면, 압축할 수 없음
            if(str.length == set.size())
                continue;

            StringBuilder sb = new StringBuilder();
            int cnt=1;
            for(int j=0;j<str.length;j++){
                if(j*divideChar+divideChar >= s.length()){ // 끝글자인 경우
                    if(cnt>=2)
                        sb.append(String.valueOf(cnt)+str[j]);
                    else
                        sb.append(str[j]);
                    break;
                }

                // 앞의 문자열과 압축할 수 있다면 몇번 압축되는지 세기
                if(str[j].equals(str[j+1])){
                    cnt++;
                }
                else {
                    if(cnt==1) {// cnt==1 이면 안붙이도록
                        sb.append(str[j]);
                    }
                    else { // cnt>=2 이면 몇번 압축가능한지 세서 붙이기
                        String finalStr = String.valueOf(cnt)+str[j];
                        sb.append(finalStr);
                        cnt=1;
                    }
                }
            }
            min = Math.min(sb.length(), min); // 가장 짧은 문자열 개수 구하기
        }
        return min;
    }
}