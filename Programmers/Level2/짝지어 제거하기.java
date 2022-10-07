/**
 [문제요약]
 알파벳 소문자로 이루어진
 같은 알파벳 2개 붙어있는 짝을 찾고 제거
 앞뒤로 이어붙임
 문자열을 모두 제거한다면 짝지어 제거하기 성공
*/
import java.util.*;
class Solution{
    public int solution(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stack.size() == 0) { // 스택이 비어있다면 넣기
                stack.push(s.charAt(i));
            }
            else { // 스택이 비어있지 않다면 새로 넣을 때 peek() 한 거랑 같으면 넣지말고 기존에 들어간 거도 pop()
                char top = stack.peek();
                if(top == s.charAt(i))
                    stack.pop();
                else
                    stack.push(s.charAt(i));
            }
        }
        if(stack.isEmpty())
            return 1;
        return 0;
    }
}