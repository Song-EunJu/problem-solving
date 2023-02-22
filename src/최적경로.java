import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최적경로 {
    static int N;
    static boolean visit[];
    static int customer[][];
    static int order[];
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
            order = new int[N+1];
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
            combination(1);
            sb.append("#"+(i+1)+" "+min+"\n");
        }
        System.out.println(sb);
    }

    private static void combination(int cnt) {
        if(cnt == N+1){
            int sum = 0;
            sum += Math.abs(customer[order[1]][0]-companyY)+Math.abs(customer[order[1]][1]-companyX);
            sum += Math.abs(customer[order[N]][0]-homeY)+Math.abs(customer[order[N]][1]-homeX);
            for(int i=2;i<=N;i++){
                int curr = order[i]; // 몇번째 손님인지
                int before = order[i-1];
                int dist = Math.abs(customer[curr][0]-customer[before][0]) +
                        Math.abs(customer[curr][1]-customer[before][1]);
                sum += dist;
                if(sum > min)
                    break;
            }
            min = Math.min(sum, min);
            return;
        }

        /**
         * 순열 코드 다시 확인필요
         * i번째를 방문했는지도 체크하고, cnt 번째 순서에 i 방문한 것도 저장해야 함
         * */
        for(int i=1;i<=N;i++){
            if(visit[i])
                continue;
            order[cnt] = i;
            visit[i] = true;
            combination( cnt+1);
            visit[i] = false;
        }
    }
}
