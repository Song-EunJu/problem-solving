import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합
public class baekjoon2798 {
    static int sum = 0;
    static int max = Integer.MIN_VALUE;
    static int N, M;
    static int cards[];
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cards = new int[N];
        visit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            cards[i] = Integer.parseInt(st.nextToken());

        blackjack(0);
        System.out.println(max);
    }

    public static void blackjack(int cnt) {
        if(cnt == 3) {
            max = Math.max(max, sum);
            return;
        }

        for(int i=0;i<N;i++) {
            if(visit[i] || sum+cards[i]>M) // 카드를 사용했거나, 사용하려고 하는 카드가 sum이랑 더했을 때 M보다 커지는 경우
                continue;

            sum += cards[i];
            visit[i] = true;
            blackjack(cnt+1);
            visit[i] = false;
            sum -= cards[i];
        }
    }
}