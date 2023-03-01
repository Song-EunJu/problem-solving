package ssafy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MST_PrimTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		int[][] adjMatrix = new int[V][V]; // 간선의 가중치를 저장
		boolean[] visited = new boolean[V]; // 신장트리에 포함여부
		int[] minEdge = new int[V]; // 해당 정점에서 뻗을 수 있는 가장 짧은 정점의 길이 담는 배열

		StringTokenizer st;
		for(int i=0;i<V;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<V;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}

		int result = 0; // MST비용

		// 임의의 정점을 시작정점으로 사용하기 위한 처리
		// 시작점이 중요한게 아니라서, 임의의 정점을 시작 정점으로 사용
		minEdge[0] = 0;

		int c;

		// V개의 정점을 모두 선택하면 신장트리 완성
		for(c=0;c<V;c++) {

			// step1: 신장트리에 포함되지 않은 정점 중 minEdge 비용이 최소인 정점 찾기
			int min = Integer.MAX_VALUE;
			int minVertex = -1;

			// 신장트리에 포함되지 않은 애들 중에 가장 유리한 애를 뽑겠다 -> 그리디적인 접근
			for(int i=0;i<V;i++) {
				if(!visited[i] && min>minEdge[i]) {
					min = minEdge[i]; // 1
					minVertex = i; // 3
				}
			}

			// 최솟값 빠르게 찾으려고 최소힙 사용
			// priority queue -> 최소힙
			// 동일한정점에 대해 서로 다른 pq의 값이 들어가 있음


			// 다음에 신장트리에 추가할 정점이 없어서 빠져나와야 하는 상황이니까
			if(minVertex == -1)
				// 정점개수에 도달하지 않은 상태에서 (마지막 상태가 아닐 때)
				// 비용이 최소인 정점을 못찾은 경우에는 최소신장트리를 만들 수 없음
				break;


			// step2: 선택된 정점 신장트리에 추가
			result += min;
			visited[minVertex] = true;

			// step3: 선택된 정점의 인접정점 (신장트리에 포함되지 않은 정점)의 간선비용의 최솟값 업데이트
			/**
			 * 선택된 정점의 인접한 정점들이, 뻗을 수 있는 가장 짧은 간선의 비용으로
			 * minEdge[i] 를 업데이트 시킴
			 * */
			for(int i=0;i<V;i++) {
				if(!visited[i] && adjMatrix[minVertex][i]!=0
						&& minEdge[i] > adjMatrix[minVertex][i]){
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		System.out.println(c==V ? result : -1);
	}
}