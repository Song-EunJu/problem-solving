import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 우선순위큐는 내부적으로 힙으로 구현되어 있으니까, 우선순위큐로 풀 수 있지 않을까
 * 절댓값이 작은 게 우선순위 1순위
 * 절댓값이 작은 게 여러 개면, 그 중에서 가장 작은 수 2순위
 *
 * Queue<Integer> queue = new PriorityQueue<>() 이 놈은 내부적으로 오름차순정렬
 * compareTo 를 재정의해서 쓰자
 *
 * */
public class baekjoon11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int abs = Math.abs(o1) - Math.abs(o2);
            if (abs == 0)
                /**
                 * 절댓값이 같으면 o1 = -2, o2 = 2 인 경우 -4 니까 자리 안바꿈
                 * -> 작은 값이 앞으로 옴
                 * */
                return o1 - o2;
            else
                /**
                 * 만약 o1 = -2 / o2 = 1 인 경우, 양수를 리턴하니까 자리를 변경
                 * -> 절댓값이 작은 값이 앞으로 옴.
                 * */
                return abs;
        });

        for(int i=0;i<N;i++){
            int n = Integer.parseInt(br.readLine());
            if(n!=0)
                queue.add(n);
            else if(n==0) {
                if (queue.isEmpty())
                    sb.append("0\n");
                else
                    sb.append(queue.poll() + "\n");
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
