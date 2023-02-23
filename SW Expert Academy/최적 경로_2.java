//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class 최적경로 {
//    static int N;
//    static boolean visit[];
//    static int customer[][];
//    static int order[];
//    static int companyY, companyX, homeY, homeX;
//    static int min;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int T = Integer.parseInt(br.readLine());
//        StringTokenizer st;
//        for(int i=0;i<T;i++){
//            min = Integer.MAX_VALUE;
//            N = Integer.parseInt(br.readLine());
//            customer = new int[N+1][2];
//            order = new int[N+1];
//            visit = new boolean[N+1];
//
//            st = new StringTokenizer(br.readLine());
//            companyY = Integer.parseInt(st.nextToken());
//            companyX = Integer.parseInt(st.nextToken());
//            homeY = Integer.parseInt(st.nextToken());
//            homeX = Integer.parseInt(st.nextToken());
//            for(int j=1;j<=N;j++) {
//                customer[j][0] = Integer.parseInt(st.nextToken());
//                customer[j][1] = Integer.parseInt(st.nextToken());
//            }
//            combination(1);
//            sb.append("#"+(i+1)+" "+min+"\n");
//        }
//        System.out.println(sb);
//    }
//
//    private static void combination(int cnt) {
//        if(cnt == N+1){
//            int sum = 0;
//            sum += Math.abs(customer[order[1]][0]-companyY)+Math.abs(customer[order[1]][1]-companyX);
//            sum += Math.abs(customer[order[N]][0]-homeY)+Math.abs(customer[order[N]][1]-homeX);
//            for(int i=2;i<=N;i++){
//                int curr = order[i]; // 몇번째 손님인지
//                int before = order[i-1];
//                int dist = Math.abs(customer[curr][0]-customer[before][0]) +
//                        Math.abs(customer[curr][1]-customer[before][1]);
//                sum += dist;
//                if(sum > min)
//                    break;
//            }
//            min = Math.min(sum, min);
//            return;
//        }
//
//        /**
//         * 순열 코드 다시 확인필요
//         * i번째를 방문했는지도 체크하고, cnt 번째 순서에 i 방문한 것도 저장해야 함
//         * */
//        for(int i=1;i<=N;i++){
//            if(visit[i])
//                continue;
//            order[cnt] = i;
//            visit[i] = true;
//            combination( cnt+1);
//            visit[i] = false;
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최적경로 {
    static int N;
    static boolean visit[];
    static int customer[][];
    static int companyY, companyX, homeY, homeX;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<T;i++){
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            customer = new int[N+1][2];
            visit = new boolean[N+1];

            st = new StringTokenizer(br.readLine());
            companyY = Integer.parseInt(st.nextToken());
            companyX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());
            homeX = Integer.parseInt(st.nextToken());
            for(int j=1;j<=N;j++) {
                customer[j][0] = Integer.parseInt(st.nextToken());
                customer[j][1] = Integer.parseInt(st.nextToken());
            }
            combination(1, 0, companyY, companyX);
            sb.append("#"+(i+1)+" "+min+"\n");
        }
        System.out.println(sb);
    }

    private static void combination(int cnt, int sum, int y1, int x1) {
        if(sum > min)
            return;

        if(cnt == N+1){
            /** 여기서 y1, x1 이 마지막 고객 집 좌표니까 getDistance 함수 써서 다시 계산 */
            sum += getDistance(homeY, homeX, y1, x1);
            min = Math.min(sum, min);
            return;
        }

        /**
         * i=1 부터 N 까지 탐색하면서 order 배열에 순서를 저장해두려고 순열 코드를 사용했었음
         * -> 근데 방문순서를 굳이 order 배열에 저장할 필요가 없었음
         * -> 그냥 visit 체크하면서 돌아댕기면 됨. 단순 재귀
         * */
        for(int i=1;i<=N;i++){
            if(visit[i])
                continue;
            visit[i] = true;
            int nextY = customer[i][0];
            int nextX = customer[i][1];
            /** 순열을 모두 완성한 이후에 order 배열을 돌면서 sum 을 더하는 것보다
             * 매번 선택할 때마다 sum 을 더하면서 sum 값이 min보다 미리 커지는 경우에 break 시켜버림 */
            combination( cnt+1, sum+getDistance(y1, x1, nextY, nextX), nextY, nextX);
            visit[i] = false;
        }
    }

    // y1 - customerY / x1=customerX
    public static int getDistance(int y1, int x1, int y2, int x2){
        return Math.abs(y1-y2)+Math.abs(x1-x2);
    }
}