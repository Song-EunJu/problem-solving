import java.lang.*;
class Solution {
    public long solution(long n) {

        // n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수


        long num=(long)Math.sqrt(n); //11

        if(num*num!=n)
            return -1;
        else
            return (num+1)*(num+1);


    }
}