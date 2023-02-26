//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
///**
// // * - 각 칸에 포함된 적의 수는 최대 하나
// // * - 격자 판 외부에, n번행의 바로 아래의 모든 칸에 성이 존재
// // * - 성을 지키기 위한 궁수 3명 배치
// // * 	(궁수는 성이 있는 칸에 배치 가능 / 하나의 칸에는 최대 1명의 궁수)
// *
// * - 각 턴마다 궁수는 적 하나 공격, 모든 궁수는 동시 공격
// * - 공격하는 적은, 거리가 D 이하인 적 중 가장 가까운 적 / 여러명이면 가장 왼쪽 적 공격
// * - 같은 적이 여러 궁수에게 공격 당하기 가능, 공격받으면 게임에서 제외
// * - 궁수의 공격 끝나고 적은 아래로 한 칸 이동. 성이 있는 곳으로 이동하면 게임에서 제외
// * 종료조건 : 모든적이 격자판에서 제외되는 경우
// **
// * */
//public class baekjoon17135 {
//    static int map[][]; // 이거 인접리스트로 바꿔도 될 것 같음
//    static int dp[][];
//    static boolean visit[][];
//    static int N, M, D;
//    static int max = Integer.MIN_VALUE;
//    static List<int[]> archers;
//    static int enemy;
//    static int tempEnemy;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken()); // 가로
//        M = Integer.parseInt(st.nextToken()); // 세로
//        D = Integer.parseInt(st.nextToken()); // 공격거리 제한
//
//        map = new int[N+1][M];
//        archers = new ArrayList<>();
//
//        for(int i=0;i<N;i++) {
//            st = new StringTokenizer(br.readLine());
//            for(int j=0;j<M;j++) {
//                int num = Integer.parseInt(st.nextToken());
//                if(num == 1)
//                    enemy++; // 적 몇 명인지 세기
//                map[i][j] = num;
//            }
//        }
//        combination(0, 0);
//        System.out.println(max);
//    }
//
//    private static void combination(int cnt, int start) {
//        // 궁수의 위치를 다 뽑은 경우 게임 시작
//        if(cnt == 3) {
//            dp = new int[N+1][M];
//            visit = new boolean[N+1][M];
//            tempEnemy = enemy;
//
//            // deep copy
//            for(int i=0;i<dp.length;i++)
//                System.arraycopy(map[i], 0, dp[i], 0, map[i].length);
//
//            int res = 0;
//            while(tempEnemy != 0){ // 모든 적이 격자에서 사라지면 게임이 끝남
//                List<int[]> killTarget = new ArrayList<>(); // 죽일 적 리스트
//
//
//                for(int i=0;i<3;i++) {
//                    // 궁수의 위치 좌표
//                    int archerY = archers.get(i)[0];
//                    int archerX = archers.get(i)[1];
//
//                    // 적은 거리가 D이하인 적 중에서 가장 가까운 적 찾기
//                    int[] target = findMinPos(archerY, archerX);
//
//                    // 거리가 D초과인 적이 아닌 경우에만 killTarget 에 추가
//                    if(target[0] != -1 && target[1] != -1)
//                        killTarget.add(target);
//                }
//
//                // 같은 적이 여러 궁수한테 공격당할 수 있는데 list 에는 적의 좌표의 중복이 제거되지 않은 상태
//                // 한명 궁수가 죽일 때마다 해당 적의 visit 배열 인덱스를 true 로 바꿔줌.
//                for(int[] target: killTarget) {
//                    if(!visit[target[0]][target[1]]) { // 적이 있는 위치 방문한적 없다면,
//                        visit[target[0]][target[1]] = true;
//                        res++;
//                    }
//                }
//
//                // 적의 이동
//                moveEnemy();
//
//                if(killTarget.size() == 0 && tempEnemy==0) // 최단거리에 들어오지 못해서 killTarget 에 넣지 못하는데, enemy 를 다 죽이지 못한 경우
//                    break;
//            }
//            max = Math.max(max, res); // 궁수의 공격으로 제거가능한 적의 최대 수
//            return;
//        }
//
//        // 조합은 순서가 중요하지 않으니까 start 지점 구하기
//        for(int i=start;i<M;i++) {
//            int []archer = new int[]{N, i};
//            archers.add(archer); // 궁수의 위치를 list에 저장
//            combination(cnt+1, i+1);
//            archers.remove(archer);
//        }
//    }
//
//    private static void moveEnemy() {
//        int lastEnemy = 0;
//        for(int i=N-1;i>=1;i--){
//            if(i==N-1){ // 마지막 줄에서 사라지는 적의 수 세기
//                for(int j=0;j<M;j++){
//                    if(dp[i][j]==1)
//                        lastEnemy++;
//                }
//            }
//            dp[i] = dp[i-1]; // map 이 아니라 새로운 배열 받아서 해야할 듯..
//            visit[i] = visit[i-1]; // 방문 경로 배열도 내리기
//        }
//        Arrays.fill(dp[0], 0); // 첫줄은 다 0
//        Arrays.fill(visit[0], false); // 첫줄은 다 0
//
//        // 적의 인원 수 빼주기 (마지막 줄 적은 성이 있는 칸으로 이동해서 게임에서 제외되었기 때문)
//        tempEnemy -= lastEnemy;
//    }
//
//    // 최단거리인 적의 좌표 찾기
//    private static int[] findMinPos(int archerY, int archerX){
//        int minPosY = -1;
//        int minPosX = -1;
//        int min = Integer.MAX_VALUE;
//        for(int n=N-1;n>=0;n--) {
//            for(int m=0;m<M;m++) {
//                if(dp[n][m] == 1) { // 적인 경우
//                    int dist = getDistance(n, m, archerY, archerX);
//                    if (dist <= D) { // 궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적을 찾아야 함.
//                        if (dist < min) {
//                            min = dist;
//                            minPosY = n;
//                            minPosX = m;
//                        } else if (dist == min) {
//                            if (m < minPosX) { // 가장 가까운 적이 여러 명인 경우에 가장 왼쪽에 있는 적을 공격함
//                                minPosY = n;
//                                minPosX = m;
//                            }
//                        }
//                        // 최솟값의 x좌료가 3인애가 1인 애보다 먼저 나온 경우에, 1인애로 업뎃시켜야 함
//                        // 그니까 최솟값이 나온 위치도 저장해두고 있어야 함.
//                    }
//                }
//            }
//        }
//        return new int[]{minPosY, minPosX};
//    }
//
//    private static int getDistance(int y1, int x1, int y2, int x2) {
//        return Math.abs(y1-y2) + Math.abs(x1-x2);
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 // * - 각 칸에 포함된 적의 수는 최대 하나
 // * - 격자 판 외부에, n번행의 바로 아래의 모든 칸에 성이 존재
 // * - 성을 지키기 위한 궁수 3명 배치
 // * 	(궁수는 성이 있는 칸에 배치 가능 / 하나의 칸에는 최대 1명의 궁수)
 *
 * - 각 턴마다 궁수는 적 하나 공격, 모든 궁수는 동시 공격
 * - 공격하는 적은, 거리가 D 이하인 적 중 가장 가까운 적 / 여러명이면 가장 왼쪽 적 공격
 * - 같은 적이 여러 궁수에게 공격 당하기 가능, 공격받으면 게임에서 제외
 * - 궁수의 공격 끝나고 적은 아래로 한 칸 이동. 성이 있는 곳으로 이동하면 게임에서 제외
 * 종료조건 : 모든적이 격자판에서 제외되는 경우
 **
 * */
public class baekjoon17135 {
    static int map[][]; // 이거 인접리스트로 바꿔도 될 것 같음
    static int dp[][];
    static boolean visit[][];
    static int N, M, D;
    static int max = Integer.MIN_VALUE;
    static List<int[]> archers;
    static int enemy;
    static int tempEnemy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로
        D = Integer.parseInt(st.nextToken()); // 공격거리 제한

        map = new int[N+1][M];
        dp = new int[N+1][M];

        archers = new ArrayList<>();

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1)
                    enemy++; // 적 몇 명인지 세기
                map[i][j] = dp[i][j] = num;
            }
        }
        combination(0, 0);
        System.out.println(max);
    }

    private static void combination(int cnt, int start) {
        // 궁수의 위치를 다 뽑은 경우 게임 시작
        if(cnt == 3) {
            visit = new boolean[N+1][M];
            tempEnemy = enemy;

            int res = 0;
            while(tempEnemy != 0){ // 모든 적이 격자에서 사라지면 게임이 끝남
                List<int[]> killTarget = new ArrayList<>(); // 죽일 적 리스트


                for(int i=0;i<3;i++) {
                    // 궁수의 위치 좌표
                    int archerY = archers.get(i)[0];
                    int archerX = archers.get(i)[1];

                    // 적은 거리가 D이하인 적 중에서 가장 가까운 적 찾기
                    int[] target = findMinPos(archerY, archerX);

                    // 거리가 D초과인 적이 아닌 경우에만 killTarget 에 추가
                    if(target[0] != -1 && target[1] != -1)
                        killTarget.add(target);
                }

                // 같은 적이 여러 궁수한테 공격당할 수 있는데 list 에는 적의 좌표의 중복이 제거되지 않은 상태
                // 한명 궁수가 죽일 때마다 해당 적의 visit 배열 인덱스를 true 로 바꿔줌.
                for(int[] target: killTarget) {
                    if(!visit[target[0]][target[1]]) { // 적이 있는 위치 방문한적 없다면,
                        visit[target[0]][target[1]] = true;
                        res++;
                    }
                }

                // 적의 이동
                moveEnemy();

                if(killTarget.size() == 0 && tempEnemy==0) // 최단거리에 들어오지 못해서 killTarget 에 넣지 못하는데, enemy 를 다 죽이지 못한 경우
                    break;
            }
            max = Math.max(max, res); // 궁수의 공격으로 제거가능한 적의 최대 수
            return;
        }

        // 조합은 순서가 중요하지 않으니까 start 지점 구하기
        for(int i=start;i<M;i++) {
            int [] archer = new int[]{N, i};
            archers.add(archer); // 궁수의 위치를 list에 저장
            combination(cnt+1, i+1);
            archers.remove(archer);
        }
    }

    private static void moveEnemy() {
        int lastEnemy = 0;
        for(int i=N-1;i>=1;i--){
            if(i==N-1){ // 마지막 줄에서 사라지는 적의 수 세기
                for(int j=0;j<M;j++){
                    if(dp[i][j]==1)
                        lastEnemy++;
                }
            }
            dp[i] = dp[i-1]; // map 이 아니라 새로운 배열 받아서 해야할 듯..
            visit[i] = visit[i-1]; // 방문 경로 배열도 내리기
        }
        Arrays.fill(dp[0], 0); // 첫줄은 다 0
        Arrays.fill(visit[0], false); // 첫줄은 다 0

        // 적의 인원 수 빼주기 (마지막 줄 적은 성이 있는 칸으로 이동해서 게임에서 제외되었기 때문)
        tempEnemy -= lastEnemy;
    }

    // 최단거리인 적의 좌표 찾기
    private static int[] findMinPos(int archerY, int archerX){
        int minPosY = -1;
        int minPosX = -1;
        int min = Integer.MAX_VALUE;
        for(int n=N-1;n>=0;n--) {
            for(int m=0;m<M;m++) {
                if(dp[n][m] == 1) { // 적인 경우
                    int dist = getDistance(n, m, archerY, archerX);
                    if (dist <= D) { // 궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적을 찾아야 함.
                        if (dist < min) {
                            min = dist;
                            minPosY = n;
                            minPosX = m;
                        } else if (dist == min) {
                            if (m < minPosX) { // 가장 가까운 적이 여러 명인 경우에 가장 왼쪽에 있는 적을 공격함
                                minPosY = n;
                                minPosX = m;
                            }
                        }
                        // 최솟값의 x좌료가 3인애가 1인 애보다 먼저 나온 경우에, 1인애로 업뎃시켜야 함
                        // 그니까 최솟값이 나온 위치도 저장해두고 있어야 함.
                    }
                }
            }
        }
        return new int[]{minPosY, minPosX};
    }

    private static int getDistance(int y1, int x1, int y2, int x2) {
        return Math.abs(y1-y2) + Math.abs(x1-x2);
    }
}