/**
 * 가능한 모든 경기 결과를 탐색해서 주어진 결과를 만족하는 경우가 있는지 찾자 !
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon6987 {
    static int arr[][];
    static boolean flag;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[6][3];

        /**
         * A - B.C.D.E.F
         * B - C.D.E.F
         * C - D.E.F
         * D - E.F
         * E - F
         *
         * 총 15번의 경기
         */

        // 총 15번의 경기 (A VS B) 를 담는 배열
        int[][] matches = new int[15][2];
        int idx = 0;
        for(int i=0;i<5;i++){
            for(int j=i+1;j<6;j++){
                matches[idx][0] = i;
                matches[idx][1] = j;
                idx++;
            }
        }

        for(int i=0;i<4;i++) {
            flag = false;
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 3; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    sum += arr[j][k];
                }
            }
            if(sum != 30) // 경기 수의 합이 30이 아닌 경우 -> 경기 수도 못채워? 이건 무조건 아니지
                sb.append("0");
            else {
                backtracking(matches, 0);
                if(flag)
                    sb.append("1");
                else
                    sb.append("0");
            }
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void backtracking(int[][] matches, int i) {
        if(flag) //성공 조건 맞으면 빠르게 종료하기 위함
            return;

        if(i == 15) {
            flag = true;
            return;
        }

        // A vs. B 의 결과는 승-패 / 무-무 / 패-승인 경우가 존재함
        int winner = matches[i][0];
        int loser = matches[i][1];

        // 승 - 패
        if(arr[winner][0] > 0 && arr[loser][2] > 0){
            arr[winner][0]--;
            arr[loser][2]--;
            backtracking(matches, i+1);
            arr[winner][0]++;
            arr[loser][2]++;
        }

        // 무 - 무
        if(arr[winner][1] > 0 && arr[loser][1] > 0){
            arr[winner][1]--;
            arr[loser][1]--;
            backtracking(matches, i+1);
            arr[winner][1]++;
            arr[loser][1]++;
        }

        // 패 - 승
        if(arr[winner][2] > 0 && arr[loser][0] > 0){
            arr[winner][2]--;
            arr[loser][0]--;
            backtracking(matches, i+1);
            arr[winner][2]++;
            arr[loser][0]++;
        }
    }

}


