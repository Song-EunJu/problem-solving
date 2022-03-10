/*
    처음엔 최대공약수를 구해서 원래 값들을 최대공약수로 나눈 값을 곱하면 된다고 생각했는데
    [3,9,4,16] -> 으로 했을 때는 최대공약수가 1이라서 이상한 값이 나옴
*/
class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        // n개 수의 최소공배수 구하기
        for(int i=0;i<arr.length-1;i++){
            int gcd = gcd(arr[i], arr[i+1]); // 일단 최대공약수를 구해!

            answer = arr[i]/gcd * arr[i+1]/gcd * gcd; // 최소공배수를 구하고
            arr[i+1] = answer; // arr[i+1] 를 최소공배수로 두고 그다음 작업을 함
        }
        return answer;
    }

    // 최대공약수 구하기
    public int gcd(int a, int b){
        while(b!=0){
            int r=a%b; // 나머지
            a=b;
            b=r;
        }
        return a;
    }
}