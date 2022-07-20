import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 인접행렬 -> 메모리초과 -> 인접리스트로 변경
 * 재귀 + 스택 -> 시간초과 -> 스택만 사용하여 for문 돌기
 *
 * */
public class baekjoon24479 {
    static int n;
    static Stack<Integer> stack = new Stack<>();
    static int order[];
    static boolean visit[];
    static ArrayList<ArrayList<Integer>> list;
    // 인접리스 트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점

        list = new ArrayList<>();
        order = new int[n+1]; // 순서 출력할 배열
        visit = new boolean[n+1]; // 방문 여부 배열
        int m = Integer.parseInt(st.nextToken()); // 간선
        int r = Integer.parseInt(st.nextToken()); // 시작 정점
        int count = 0;

        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){ // 무방향 그래프이므로 두 부분 다 1로 초기화
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        // 여기서 arraylist 를 스택에 넣기 위해 내림차순으로 정렬
        for(int i=0;i<=n;i++) {
            list.get(i).sort(Comparator.reverseOrder());
        }

        stack.push(r);
        while(!stack.isEmpty()){
            int start = stack.peek();
            if(visit[start] == false) {
                order[stack.pop()] = ++count; // 꺼내면서 계산 1->1
                visit[start] = true;  // 꺼내면서 true로 바꾸기
            }
            else
                stack.pop();

            // 인접한 애들 넣기
            for(int i=0;i<list.get(start).size();i++){
                int el = list.get(start).get(i);
                if(visit[el] == false) // 방문하지 않은 경우에만 넣기
                    stack.push(el); // 스택 아래쪽부터 4,2
            }
        }

        for(int i=1;i<=n;i++){
            if(visit[i] == false) // 방문할 수 없는 경우 = visit false 인 경우
                System.out.println(0);
            else
                System.out.println(order[i]);
        }
    }
}
/* 1
* 1 2 4 3 (이게 다임)
* 1ㅡ 2,3,4
* 2ㅡ 4
* 넣을 때부터 true 로 만들지말고, 일단 겹쳐도 넣어. 넣고 true인 경우 알아서~
* 4 3 2 4
*
*
*
* [반례]
* 4 4 1
1 2
1 3
1 4
2 4
* */

