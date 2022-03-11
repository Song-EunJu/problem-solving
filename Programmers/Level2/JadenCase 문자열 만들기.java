/*
    1. 일단 문자열을 다 소문자로 만든다
    2. 첫글자가 소문자인 경우 대문자로 변경
    3. 공백이 여러 개 있을 수 있으므로 앞글자가 공백 / 뒷글자는 소문자인 경우에만 대문자로 변경
*/
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s.toLowerCase());
        if(sb.charAt(0)>='a' && sb.charAt(0)<='z') {
            sb.setCharAt(0, (char)(sb.charAt(0)-32));
        }
        for(int i=1;i<s.length()-1;i++){
            if(sb.charAt(i-1)==' ' && sb.charAt(i)>='a' && sb.charAt(i)<='z') {
                sb.setCharAt(i, (char)(sb.charAt(i)-32));
            }
        }
        return sb.toString();
    }
}