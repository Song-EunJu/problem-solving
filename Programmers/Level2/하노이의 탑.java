class Solution {
    static int[][] answer;
    static int cnt=0;
    public int[][] solution(int n) {
        int total=1;
        for(int i=0;i<n;i++){
            total*=2;
        }

        answer = new int[total-1][2];

        // 최종 목표가 1번 기둥에서 3번 기둥으로, 2번 기둥을 이용해서 원판을 다 옮기는 것
        hanoi(n, 1, 3, 2);

        return answer;
    }

    public void hanoi(int n, int from, int to, int help){
        // 종료조건
        if(n==1){
            answer[cnt][0] = from;
            answer[cnt][1] = to;
            cnt++;
            return;
        }

        // 1번에 있는 n-1개의 원판을 2번으로, 3번을 이용해서 옮기는 코드
        hanoi(n-1, from, help, to);

        // 1번에 있는 원판을 3번으로 이동하는 코드
        hanoi(1, from, to, help);

        // 2번에 있는 n-1개의 원판을 3번으로, 1번을 이용해서 옮기는 코드
        hanoi(n-1, help, to, from);
    }
}