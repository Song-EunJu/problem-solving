class Solution {
    public String solution(String s, int n) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
        
            if(ch==' '){ // 공백인 경우 
                sb.append(' ');
                continue;
            }
            
            /*
                기존의 ch도 소문자이고, n을 더한 값도 소문자 영역이면 아무것도 안하고 그게 아닌 경우는 ch-=26 해준다
                예를 들어 Z 인 경우 +10 한 게 d 여서 계속 이상한 값이 나오니까 소문자 대문자 구별도 해야 함
            */
            if((((ch>='a' && ch<='z') &&(ch+n)>='a' && (ch+n)<='z')) || ((ch>='A' && ch<='Z') && (ch+n)>='A' && (ch+n)<='Z'))
                ;
            else
                ch-=26;
            ch+=n;
            sb.append(ch);
        }
        return sb.toString();
    }
}
