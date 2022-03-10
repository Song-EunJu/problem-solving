class Solution {
    boolean solution(String s) {
        int left=0, right=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                left++;
            else
                right++;

            if(left>=1 && right>=1){
                if(left<=right){
                    right-=left;
                    left=0;
                }
                else{
                    left-=right;
                    right=0;
                }
            }
            else if(left==0 && right>=1)
                return false;
        }

        if(left==0 && right==0)
            return true;
        else
            return false;
    }
}

/*
class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int count = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '('){
                count++;
            }
            if(s.charAt(i) == ')'){
                count--;
            }
            if(count < 0){
                break;
            }
        }
        if(count == 0){
            answer = true;
        }

        return answer;
    }
}
*/