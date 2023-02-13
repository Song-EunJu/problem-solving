import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon1158 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//        List<Integer> list = new ArrayList<>();
//        for(int i=1;i<=N;i++)
//            list.add(i);
//
//        sb.append("<");
//
//        while(!list.isEmpty()) {
//            for(int i=0;i<K-1;i++) {
//                list.add(list.get(0));
//                list.remove(0);
//            }
//            if(list.size() == 1)
//                sb.append(list.get(0)+">");
//            else
//                sb.append(list.get(0)+", ");
//            list.remove(0);
//        }
//        System.out.println(sb);
//    }

    /**
     * 1. Deque : 양방향 연결 리스트
     * - deque is capable of inserting or deleting elements
     *   from both ends of a queue with constant O(1) performance.
     *
     * 2. ArrayList : 내부가 배열로 구성되어 있어서, remove 하는 순간 다 땡겨야 함 -> O(n)
     * */

    // deque
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Deque<Integer> dq = new ArrayDeque<>();
		for(int i=1;i<=N;i++)
			dq.add(i);

		sb.append("<");
		while(!dq.isEmpty()) {
			for(int i=0;i<K-1;i++)
				dq.add(dq.poll());
			if(dq.size() == 1)
				sb.append(dq.poll()+">");
			else
				sb.append(dq.poll()+", ");
		}
		System.out.println(sb);
	}
}