//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//// 이진 트리에서 임의의 두 정점의 가장 가까운 공통 조상을 찾고, 그 정점을 루트로 하는 서브 트리의 크기를 알아내는 프로그램
//class Node {
//    int num;
//    Node parent;
//
//    Node(int num, Node parent){
//        this.num = num;
//        this.parent = parent;
//    }
//}
//public class test {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        StringTokenizer st;
//        Queue<Node> list = new LinkedList<>();
//        for (int i = 0; i < T; i++) {
//            Node firstNode = new Node(1, null);
//            list.add(firstNode);
//
//            st = new StringTokenizer(br.readLine());
//            int V = Integer.parseInt(st.nextToken());
//            int E = Integer.parseInt(st.nextToken());
//            int N = Integer.parseInt(st.nextToken());
//            int M = Integer.parseInt(st.nextToken());
//            st = new StringTokenizer(br.readLine());
//
//            for(int j=0;j<E;j++){
//                int parent = Integer.parseInt(st.nextToken()); // 2
//                int child = Integer.parseInt(st.nextToken()); // 4
//                if(parent == 1) {
//                    Node node = new Node(child, firstNode);
//                    list.add(node);
//                }
//                else {
//                    Node parent = new Node(parent, ㅕㅇ : );
//                    // 2의 parent를 찾아야 함.
//                    Node parentIdx = list.
//                    Node child = new Node(child, parent);
//                }
//            }
//        }
//    }
//}
