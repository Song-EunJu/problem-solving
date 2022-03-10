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