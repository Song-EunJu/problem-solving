//class Solution {
//    boolean solution(String s) {
//        int left=0, right=0;
//
//        for(int i=0;i<s.length();i++){
//            if(s.charAt(i)=='(')
//                left++;
//            else
//                right++;
//
//            if(left>=1 && right>=1){
//                if(left<=right){
//                    right-=left;
//                    left=0;
//                }
//                else{
//                    left-=right;
//                    right=0;
//                }
//            }
//            else if(left==0 && right>=1)
//                return false;
//        }
//
//        if(left==0 && right==0)
//            return true;
//        else
//            return false;
//    }
//}

/*
    1. 왼쪽 괄호가 나오면 left 변수를 증가
    2. 오른쪽 괄호가 나오면 right 변수를 증가시키면서, left 괄호가 더 많은 지 확인
    - 왼쪽 괄호가 더 많은 상태라면 올바른 괄호가 생길 가능성이 아직 있으므로 왼쪽 괄호, 오른쪽 괄호의 수를 하나씩만 줄여주고 계속 진행
    - 이 때, right>=left 인 순간부터는 무조건 false 이므로 for문 내에서 바로 return
    3. for문을 다 돌았을 때 올바른 괄호인 경우라면 left, right 개수가 같아야 함.
       같지 않은 경우 false 리턴
*/
class Solution {
    boolean solution(String s) {
        int left=0, right=0;

        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '(')
                left++;
            else {
                right++; // 오른쪽 괄호가 나왔을 때 닫아주기
                if(left>=right){
                    left--;
                    right--;
                }
                else
                    return false;
            }
        }
        if(left!=right)
            return false;
        return true;
    }
}
