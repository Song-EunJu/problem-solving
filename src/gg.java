import java.util.Stack;

class gg {
    public static void main(String[] args) {
        System.out.println(solution("<><??>>"));
        System.out.println(solution("??????"));
        System.out.println(solution("<<?"));
        System.out.println(solution("<<????"));
        System.out.println(solution("<?<??<"));
        System.out.println(solution("<?<?<?"));
        // 얘를 따져보려면 다 돌아야 함
//        '<<????'
//        '<?<??<'
//        '<?<?<?'
    }

    public static int solution(String S) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == '<' || S.charAt(i) == '?')
                stack.push(S.charAt(i));
            else {
                if(stack.peek() == '<')
                    stack.pop();
                else
                    stack.push(S.charAt(i));
            }
        }

        while (!stack.isEmpty() && (stack.peek() == '<')) { // 어차피 짝 안맞는 거 다지워
            stack.pop();
        }


        if(stack.size() % 2==0)
            return stack.size(); // ??????
        else
            return stack.size()-1; // <??>> 같은 경우

//        int right = 0;
//        int left = 0;
//        int question = 0;
//        int result = 0;
//        while(!stack.isEmpty()){
//            if(right == 0 && left > 0) {
//                result += left * 2;
//                left = 0;
//            }
//
//            Character ch = stack.pop();
//            if(ch == '>')
//                right++;
//            else if(ch == '?'){
//                if(right > 0) {
//                    left++;
//                    right--;
//                }
//                else { // 아무것도 없는 상황에서 나오면
//                    question++;
//                    right++;
//                }
//            }
//            else if(ch == '<'){
//                // right가 없는 상황에서 나오면 아무것도아님.
//                if(right > 0) {
//                    left++;
//                    right--;
//                }
//            }
//        }
//        if(question % 2 == 0)
//            result += question;
//        else
//            result += question-1;
    }
}
//    select Name, Description, if(IsEnabled = 0, 'DISABLED', 'ENABLED') as Status
//        from UserRole
//        where description is not null
//        and Upper(Replace(CreatedBy,' ','')) = Upper('JohnSmith')
//        and (Created > '2020-01-03' and Created < '2020-01-07')
//        and Updated is null
//        order by Name desc

//class Solution {
//    public int solution(String S) {
//        int alpha[] = new int[26];
//        for(int i=0;i<S.length();i++){
//            alpha[S.charAt(i)-97]++;
//        }
//        int cnt = 0;
//        for(int i=0;i<26;i++){
//            if(alpha[i]%2!=0)
//                cnt++;
//        }
//        return cnt;
//    }
//}
