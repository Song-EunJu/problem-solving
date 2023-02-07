import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon15649 {
    static int N, M;
    static boolean visit[];
    static int num[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N+1];
        num = new int[M];
        permutation(0);
        System.out.println(sb);
    }

    public static void permutation(int idx) {
        if(M == idx) {
            for(int i=0;i<M;i++)
                sb.append(num[i]+" ");
            sb.append("\n");
            return;
        }

        for(int i=1;i<=N;i++) {
            if(visit[i])
                continue;
            num[idx] = i;
            visit[i] = true;
            permutation(idx+1);
            visit[i] = false;
        }
    }
}
