import java.util.*;
class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();

        // 1단계 - 소문자로 치환
        new_id = new_id.toLowerCase();

        // 2단계 - 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        for(int i=0;i<new_id.length();i++){
            char ch = new_id.charAt(i);
            if(ch>='a' && ch<='z')
                sb.append(ch);
            else if(ch>='0' && ch<='9')
                sb.append(ch);
            else if(ch=='-' || ch=='_' || ch=='.')
                sb.append(ch);

        }

        // 3단계 2번이상 연속된 부분
        for(int i=0;i<sb.length();i++){
            char ch = sb.charAt(i);
            if(ch=='.'){
                int j=i+1;
                // int count=0;
                while(j<sb.length() && sb.charAt(j)=='.'){ // . 의 개수 세기
                    sb.deleteCharAt(j);
                }
            }
        }

        // 4단계 - 마침표(.)가 처음이나 끝에 위치한다면 제거
        if(sb.length()!=0 && sb.charAt(0)=='.')
            sb.deleteCharAt(0);

        if(sb.length()!=0 && sb.charAt(sb.length()-1)=='.')
            sb.deleteCharAt(sb.length()-1);

        // 5단계 - 빈문자열이면 a 대입
        if(sb.length()==0)
            sb.append('a');

        // 6단계 - 아이디의 길이가 16자 이상이므로, 처음 15자를 제외한 나머지 문자들이 제거
        if(sb.length()>=16){
            sb.delete(15,sb.length()); // 15번째 인덱스부터 크기-1 인덱스까지 삭제
            if(sb.length()>=1 && sb.charAt(sb.length()-1)=='.')
                sb.deleteCharAt(sb.length()-1);
        }

        // 7단계 - 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다
        if(sb.length()<=2){
            char ch = sb.charAt(sb.length()-1);
            while(sb.length()!=3){
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}