class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown+yellow; // 총 격자 개수
        int answer[]=new int[2];

        if(yellow==1){
            answer[0]=3;
            answer[1]=3;
            return answer;
        }

        for(int i=1;i<=yellow/2;i++){
            if(i>yellow/i)
                break;

            if((i+2)*(yellow/i+2)==total){
                answer[0]=yellow/i+2;
                answer[1]=i+2;
            }
        }
        return answer;
    }
}

/*
    1. yellow = 2
        (2,1) -> (4,3) = 4*3 = 12 = 10+2
    2. yellow = 1
        (1,1) -> (3,3) = 3*3 = 9 = 8+1
    3. yellow = 24
        (6,4) -> (8,6) = 8*6 = 48 = 24+24

    24 가 되는 조합이
    (24,1) (12,2) (8,3) (6,4) 이렇게 있지만
    (6,4) 인 경우에만 +2씩 했을 때 (8,6) => 8*6 이 brown+yellow 과 동일함
*/
class Solution {
    public int[] solution(int brown, int yellow) {
        int i=1;
        while(true){
            if(yellow%i==0) { // i가 약수인 경우
                if((i+2)*(yellow/i+2) == brown+yellow)
                    return new int[]{yellow/i+2,i+2};
            }
            i++;
        }
    }
}