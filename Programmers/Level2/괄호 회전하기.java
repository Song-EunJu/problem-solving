import java.util.*;
class Solution {
    public int solution(String s) {
        Stack<Character> stk = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        int cnt=0;
        for(int i=0;i<s.length();i++){
            int j;
            if(i!=0){ // 처음이 아닌 경우 맨 앞글자 빼서 뒤에 다시 넣기
                Character ch=sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(ch);
            }
            for(j=0;j<s.length();j++){
                if(sb.charAt(j)=='[' || sb.charAt(j)=='(' || sb.charAt(j)=='{')
                    stk.push(sb.charAt(j));
                else if(sb.charAt(j)==']'){
                    if(stk.size()!=0){ // 빈 stack 에서 peek() 할 수 없으니까 size를 먼저 체크해줌
                        if(stk.peek()=='[')
                            stk.pop();
                        else
                            break;
                    }
                    else
                        break;
                }
                else if(sb.charAt(j)==')'){
                    if(stk.size()!=0){
                        if(stk.peek()=='(')
                            stk.pop();
                        else
                            break;
                    }
                    else
                        break;
                }
                else if(sb.charAt(j)=='}'){
                    if(stk.size()!=0){
                        if(stk.peek()=='{')
                            stk.pop();
                        else
                            break;
                    }
                    else
                        break;
                }
            }
            // 문자열을 다 돌았고, stack 에 남은 것이 없는 경우에만 개수 세기
            if(j==sb.length() && stk.size()==0)
                cnt++;
        }
        return cnt;
    }
}