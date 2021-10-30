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