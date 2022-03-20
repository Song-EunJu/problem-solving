class Solution {
    public int solution(int n) {
        int answer = n;
        int oneCount=1; // n의 1개수 세기 (아래 while 문에서 마지막으로 빠져나올 때 ++을 못해주니까)
        int num=n;

        // n의 1 개수 세기
        while(num!=1){
            if(num%2!=0)
                oneCount++;
            num/=2;
        }

        // 다음 큰 수 찾기
        while(true){
            int count=1;
            answer++; // 78부터 계속 커져야 하는 정수값
            num = answer; // answer를 가지고 계속 나눠야 하므로 answer값이 바뀌지 않도록 num으로 계산
            while(num!=1){
                if(num%2!=0)
                    count++;
                num/=2;
            }
            if(count==oneCount) // 1의 개수가 같으면 그 수 리턴
                return answer;
        }
    }
}

/*
    1. 주어진 n을 2진수로 변환했을 때의 1의 갯수를 센다.
    2. while문을 돌면서 n의 1의 갯수와 같은 수일 때 break

    - Integer.toBinaryString(정수) : 정수를 2진수 문자열로 변환
    - Integer.bitCount(정수) : 이진수에서 1의 개수를 세어주는 함수
*/
class Solution {
    public int solution(int n) {
        int answer=0;
        int nCnt=0;
        int cnt=0;
        String binary = Integer.toBinaryString(n);
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)=='1'){
                nCnt++;
            }
        }
        while(true){
            answer=++n;
            cnt=0;
            binary = Integer.toBinaryString(answer);
            for(int i=0;i<binary.length();i++){
                if(binary.charAt(i)=='1'){
                    cnt++;
                }
            }
            if(nCnt==cnt)
                break;
        }
        return answer;
    }
}