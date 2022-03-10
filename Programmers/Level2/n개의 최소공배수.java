/**
 - for문을 돌면서 2개씩 연산
 1. A,B의 최대공약수 계산
 2. 1에서 구한 최대공약수를 이용해 A,B의 최소공배수 계산
 3. 2에서 구한 최소공배수가 다음 연산의 A값이 된다

 - A값이 이전 연산의 최소공배수로 사용되기 때문에 배열의 마지막 요소에는 최종적으로 N개 수의 최소공배수 저장됨
 */
class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        for(int i=0;i<arr.length-1;i++){
            int gcd = gcd(arr[i], arr[i+1]);
            answer = arr[i]/gcd * arr[i+1]/gcd * gcd;
            arr[i+1] = answer;
        }
        return answer;
    }

    public int gcd(int a, int b){
        while(b!=0){
            int r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
}