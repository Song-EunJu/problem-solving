import java.util.*;
class Solution {
    int answer;
    boolean []check = new boolean[7];  // 길이 1이상 7이하 문자열이므로 7자리짜리 배열이 필요 -> 각 숫자가 사용된지 판별하기 위해

    ArrayList<Integer> arr = new ArrayList<>(); // 만들 수 있는 숫자를 모두 담는 리스트

    public int solution(String numbers) {
        String tmp ="";
        for(int i=0;i<numbers.length();i++){ // 몇 자리의 수를 만들 지에 대한 반복, ex) 123이면 조합해서 한 자릿수~세 자릿수 수까지 생성가능
            dfs(numbers,tmp,i+1); // dfs(17,"",1); -> 한 자릿수로 만들 수 있는 숫자 구하기
        }

        for(int i=0;i<arr.size();i++){
            is_prime(arr.get(i));
        }
        return answer;
    }

    void dfs(String str, String tmp, int m){

        /*
            현재 만들어진 문자열이 m 자릿수 숫자인지 판별
            찾고 있는 자릿수와 같으면 list에 추가
        */
        if(tmp.length() == m){
            int num = Integer.parseInt(tmp);
            if(!arr.contains(num))
                arr.add(num);
            return;
        }

        /*
            각 숫자의 글자수만큼 돌면서 문자열의 인덱스 하나씩 붙여보면서 숫자를 조합
            원하던 자릿수의 숫자가 만들어지면 list에 추가하고 다시 해당 인덱스를 방문하지 않은 것으로 바꿔줌
        */

        else{
            for(int i=0;i<str.length();i++){
                if(!check[i]){ // 이미 방문한 인덱스라면 수행하지 않음
                    check[i] = true;
                    tmp += str.charAt(i);
                    dfs(str, tmp, m);
                    check[i] = false;
                    tmp = tmp.substring(0, tmp.length()-1);
                }
            }
        }
    }


    void is_prime(int n){
        if(n==0 || n==1)
            return;
        for(int i=2;i<=n/2;i++){
            if(n%i==0)
                return;
        }
        answer++;
    }
}