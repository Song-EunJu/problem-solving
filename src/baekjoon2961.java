import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 시간 초과 코드
 * public class baekjoon2961 {
 *     static int taste[][];
 *     static boolean select[]; // 재료를 선택한지 여부
 *     static int n;
 *     static long min;
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         n = Integer.parseInt(br.readLine());
 *         StringTokenizer st;
 *         taste = new int[n+1][2];
 *         select = new boolean[n+1];
 *         min = Long.MAX_VALUE;
 *
 *         for(int i=1;i<=n;i++) {
 *             st = new StringTokenizer(br.readLine());
 *             taste[i][0] = Integer.parseInt(st.nextToken());
 *             taste[i][1] = Integer.parseInt(st.nextToken());
 *         }
 *         cooking(0);
 *         System.out.println(min);
 *     }
 *
 *     public static void cooking(int cnt) {
 *         if(n == cnt) {
 *             long sour = 1;
 *             long bitter = 0;
 *             for(int i=1;i<=n;i++) {
 *                 if(select[i]) { // 사용한 재료인 경우
 *                     sour *= taste[i][0];// 신맛의 곱
 *                     bitter += taste[i][1];// 쓴맛의 합
 *                 }
 *             }
 *             if(sour != 1 && bitter != 0) // 공집합인 경우 제외
 *                 min = Math.min(Math.abs(sour-bitter), min);
 *             return;
 *         }
 *
 *         // 여기를 for문을 돌면서 했는데 그러면 시간 초과 남
 *         // -> 이 방식이 아니라 cnt의 인덱스로 접근해도 됨
 *         for(int i=1;i<=n;i++) {
 *             if(select[i])
 *                 continue;
 *             select[i] = true;
 *             cooking(cnt+1);
 *
 *             select[i] = false;
 *             cooking(cnt+1);
 *         }
 *     }
 * }
 */
public class baekjoon2961 {
    static int taste[][];
//    static boolean select[]; // 재료를 선택한지 여부
    static int n;
    static long min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        taste = new int[n+1][2];
//        select = new boolean[n+1];
        min = Long.MAX_VALUE;

        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            taste[i][0] = Integer.parseInt(st.nextToken());
            taste[i][1] = Integer.parseInt(st.nextToken());
        }

        cooking(0, 1, 0);
        System.out.println(min);
    }

    public static void cooking(int cnt, int sour, int bitter) {
        if(n == cnt) {
            if(sour != 1 && bitter != 0)  // 공집합이 아닌 경우
                min = Math.min(Math.abs(sour-bitter), min);
            return;
        }

        // 이 문장 없어도 됨 -> select[cnt+1] 에 방문하지 않는 문장은 아래 cooking(cnt+1, sour, bitter) 이므로
//		select[cnt+1] = true;
        cooking(cnt+1, sour*taste[cnt+1][0], bitter+taste[cnt+1][1]);
//		select[cnt+1] = false;
        cooking(cnt+1, sour, bitter);
    }
}