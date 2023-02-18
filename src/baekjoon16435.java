import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon16435 {
    public static void main(String[] args) throws IOException {
        // 과일 높이 정렬
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 과일 개수
        int L = Integer.parseInt(st.nextToken()); // 초기 길이 정수
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++)
            q.add(Integer.parseInt(st.nextToken()));

        while(!q.isEmpty() && L >= q.peek()){
            q.poll();
            L++;
        }
        System.out.println(L);

    }
}
