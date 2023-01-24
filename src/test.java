import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    1. 이진 트리에서 임의의 두 정점의 가장 가까운 공통 조상을 찾고,
    ->
    2. 그 정점을 루트로 하는 서브 트리의 크기를 알아내기
    -> bfs 로 해당 정점과 연관된 모든 정점을 다 돌자
*/

class Node {
    private int left, right, parent;

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getParent() {
        return parent;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public Node(){
        this.left = 0;
        this.right = 0;
        this.parent = 0;
    }
}
public class test {
    static Node[] nodes;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 번호
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); // 정점 개수
            int E = Integer.parseInt(st.nextToken()); // 간선 개수

            // 정점의 번호는 1부터 V까지의 정수
            /** <변경한 점> nodes 배열 크기를 V+1 로 지정 */
            nodes = new Node[V+1];
            visited = new boolean[V+1];

            for(int j=1;j<V+1;j++){
                nodes[j] = new Node();
            }

            // 공통 조상을 찾는 두 개의 정점 번호
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<E;j++){
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                /** <변경한 점> Node parent, left, right 르 관리했는데 이를 정수로 관리 */
                nodes[child].setParent(parent);
                if(nodes[parent].getLeft() == 0) // 아직 자식이 없는 경우
                    nodes[parent].setLeft(child);
                else
                    nodes[parent].setRight(child);
            }

            int ans = findSameAncestor(N, M); // 공통 조상 찾기
            int size = getSubTree(ans); // 서브 트리 크기 찾기
            System.out.println(("#"+(i+1)+" "+ans+" "+(size+1)));
        }
    }

    public static int findSameAncestor(int n, int m){
        Node nNode = nodes[n];
        Node mNode = nodes[m];

        /** <변경한 점> 공통 조상을 뽑을 때 hashSet에 값을 넣으면서 contains 연산을 매번해줬는데
         * 이를 visit 배열로 변경하여 방문한 정점인 경우 바로 리턴하도록 */
        while(true) {
            int nParent, mParent;

            if(nNode != null) {
                nParent = nNode.getParent();
                if (visited[nParent])
                    return nParent;

                visited[nParent] = true;
                nNode = nodes[nParent];
            }

            if(mNode != null) {
                mParent = mNode.getParent();
                if (visited[mParent])
                    return mParent;

                visited[mParent] = true;
                mNode = nodes[mParent];
            }
        }
    }

    public static int getSubTree(int num){
        int cnt = 0;
        Queue<Node> q = new LinkedList<>();
        Node node = nodes[num];
        q.add(node);

        while(!q.isEmpty()){
            Node nd = q.poll();
            int left = nd.getLeft();
            int right = nd.getRight();

            if(left != 0) {
                q.add(nodes[left]);
                cnt++;
            }
            if(right != 0){
                q.add(nodes[right]);
                cnt++;
            }
        }
        return cnt;
    }
}

