import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon17471 {
    public static void main(String[] args) throws IOException {
        // 구역을 두 개의 선거구로 나눠야 하고,
        // 각 구역은 두 선거구 중 하나에 포함되어야 한다.
        // 선거구는 구역을 적어도 하나 포함해야 하고, 한 선거구에 포함되어 있는 구역은 모두 연결되어 있어야 한다.
        // 구역 A에서 인접한 구역을 통해서 구역 B로 갈 수 있을 때, 두 구역은 연결되어 있다고 한다.
        // 중간에 통하는 인접한 구역은 0개 이상이어야 하고, 모두 같은 선거구에 포함된 구역이어야 한다.

        // 두 선거구에 포함된 인구차이를 최소로 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int population[] = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            population[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for(int j=0;j<m;j++){

            }
        }

    }
}
