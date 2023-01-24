//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
///*
//    1. 이진 트리에서 임의의 두 정점의 가장 가까운 공통 조상을 찾고,
//    ->
//    2. 그 정점을 루트로 하는 서브 트리의 크기를 알아내기
//    -> bfs 로 해당 정점과 연관된 모든 정점을 다 돌자
//*/ *************************** 시간 초과 나는 코드 ***************************
//class Node {
//    private int num;
//    private Node left;
//    private Node right;
//    private Node parent;
//    public int getNum() {
//        return num;
//    }
//    public Node getLeft() {
//        return left;
//    }
//    public Node getRight() {
//        return right;
//    }
//    public Node getParent() {
//        return parent;
//    }
//
//    public void setParent(Node parent) {
//        this.parent = parent;
//    }
//
//    public void setLeft(Node left) {
//        this.left = left;
//    }
//
//    public void setRight(Node right) {
//        this.right = right;
//    }
//
//    public Node(int num, Node left, Node right){
//        this.num = num;
//        this.left = left;
//        this.right = right;
//    }
//
//    public Node(int num, Node left, Node right, Node parent) {
//        this(num, left, right);
//        this.parent = parent;
//    }
//}
//public class Solution {
//    static Node[] list;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine()); // 테스트케이스 번호
//        StringTokenizer st;
//        for (int i = 0; i < T; i++) {
//            list = new Node[10001];
//            st = new StringTokenizer(br.readLine());
//            int V = Integer.parseInt(st.nextToken()); // 정점 개수
//            int E = Integer.parseInt(st.nextToken()); // 간선 개수
//
//            // 공통 조상을 찾는 두 개의 정점 번호
//            int N = Integer.parseInt(st.nextToken());
//            int M = Integer.parseInt(st.nextToken());
//
//            st = new StringTokenizer(br.readLine());
//            for(int j=0;j<E;j++){
//                int parent = Integer.parseInt(st.nextToken());
//                int child = Integer.parseInt(st.nextToken());
//
//                Node parentNode = getData(parent);
//                Node childNode = new Node(child, null, null); // 자식 노드를 먼저 만들고
//                if(parentNode != null) {// 부모 노드가 존재하면
//                    if(parentNode.getLeft() == null)
//                        parentNode.setLeft(childNode);
//                    else
//                        parentNode.setRight(childNode); // 부모 노드에 자식 노드 연결
//                } else // 부모노드가 존재하지 않는다면
//                    parentNode = new Node(parent, childNode, null, null); // 부모 노드에 자식 노드 연결
//                childNode.setParent(parentNode); // 자식 노드에 부모 노드 연결
//
//                list[parent] = parentNode;
//                list[child] = childNode;
//            }
//
//            int ans = findSameAncestor(N, M); // 공통 조상 찾기
//            int size = getSubTree(ans); // 서브 트리 크기 찾기
//            System.out.println(("#"+(i+1)+" "+ans+" "+(size+1)));
//        }
//    }
//
//    // 해당 값을 num 으로 가진 node 찾기
//    public static Node getData(int num){
//        return list[num];
//    }
//    public static int findSameAncestor(int n, int m){
//        Node nNode = getData(n); // 2번 노드
//        Node mNode = getData(m); // 10번 노드
//
//        HashSet<Integer> ancestors = new HashSet<>();
//        while(true){
//            if(nNode.getParent() != null){
//                int nNum = nNode.getParent().getNum();
//                if (ancestors.contains(nNum))
//                    return nNum;
//                ancestors.add(nNum);
//            }
//
//            if(mNode.getParent() != null){
//                int mNum = mNode.getParent().getNum();
//                if (ancestors.contains(mNum))
//                    return mNum;
//                ancestors.add(mNum);
//            }
//
//            if(nNode.getParent() != null)
//                nNode = nNode.getParent(); // 1번
//
//            if(mNode.getParent() != null)
//                mNode = mNode.getParent();
//        }
//    }
//
//    public static int getSubTree(int num){
//        int cnt = 0;
//        Queue<Node> q = new LinkedList<>();
//        Node node = getData(num);
//        q.add(node);
//
//        while(!q.isEmpty()){
//            Node nd = q.poll();
//            Node left = nd.getLeft();
//            Node right = nd.getRight();
//
//            if(left != null) {
//                q.add(left);
//                cnt++;
//            }
//            if(right != null){
//                q.add(right);
//                cnt++;
//            }
//        }
//        return cnt;
//    }
//}

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

