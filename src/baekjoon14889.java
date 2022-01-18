import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon14889 {
    static int n;
    static boolean visit[];
    static int arr [][];
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        /**
         * 백트래킹 : 해를 찾는 도중 해가 아니어서 막히면, 되돌아가서 다시 해를 찾아가는 기법
         어떤 노드의 유망성, 즉 해가 될 만한지 판단한 후 유망하지 않다고 결정되면
         그 노드의 이전(부모)로 돌아가(Backtracking) 다음 자식 노드로 갑니다.
         --> 즉 답이 될 만한지 판단하고 그렇지 않으면 그 부분까지 탐색하는 것을 하지 않고 가지치기 하는 것
        */

        /**
         * 문제 해설 : 모든 조합의 경우의 수를 탐색하여 두 팀의 능력치가 최소가 되는 수를 찾고 출력한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        visit = new boolean[n];
        arr = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        startlink(0,0);
        System.out.println(min);
    }
    static void startlink(int idx, int count){
        if(count == n/2){
            cal(); // 능력치 계산
            return;
        }

        for(int i=idx;i<n;i++){
            if(!visit[i]){ // 방문하지 않았다면
                visit[i]=true;
                startlink(i+1, count+1); // (0,1,3) (2,4,5) 이런식으로 가려면 i+1 해주면서 재귀돌아야함
                visit[i]=false;
            }
        }
    }
    static void cal(){
        int start=0;
        int link=0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(visit[i] && visit[j]){ // 둘다 true 인 경우
                    start+=(arr[i][j]+arr[j][i]);
                }
                else if(!visit[i] && !visit[j]){ // 둘다 false인 경우
                    link+=(arr[i][j]+arr[j][i]);
                }
            }
        }
        if(min>Math.abs(start-link)){
            min = Math.abs(start-link);
        }
    }
}
