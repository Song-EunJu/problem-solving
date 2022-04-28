/*
    다음 라운드에 진출할 참가자의 번호를 다시 배정받음.
    1 2 3 4 5 6 7 8
     1   2   3   4
       1       2
           1
*/
class Solution {
    public int solution(int n, int a, int b) {
        int cnt=0;
        while(a!=b){
            a = (a/2)+(a%2);
            b = (b/2)+(b%2);
            cnt++;
        }
        return cnt;
    }
}