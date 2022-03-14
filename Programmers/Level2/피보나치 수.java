/**
 * - 단순 재귀함수로 풀었을 때 시간초과
 * - 배열로 풀어보자
 *  1. n=100000을 넣었을 때 ArrayIndexOutofBoundsException에러 안나기 위해서 100001 로 선언
 *  2. for 문을 돌면서 arr[i-1]+arr[i-2] 값의 나머지 값을 배열에 채워간다
 */
class Solution {
    public int solution(int n) {
        int arr[] = new int[100001];
        arr[0]=0;
        arr[1]=1;

        for(int i=2;i<100001;i++){
            arr[i]=(arr[i-1]+arr[i-2])%1234567;
        }
        return arr[n];
    }
}