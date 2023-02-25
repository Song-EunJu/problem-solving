import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 말이 최대 몇칸을 지날 수 있는가?
 * 알파벳 visit 배열생성
 * 상하좌우에 인접한 알파벳 ( 그렇지만 방문한 적 없는 ) 알파벳을 큐에 집어넣고 계산
 * 근데 큐에 집어넣을 때 몇 칸 지난 지 상태값을 저장하고 다녀야 함.
 *
 * 그래프, 가중치가 없는, 최단 거리 = BFS
 * DFS = 한놈만 팬다. CADC 한놈만 팼을 때 최단인지 아닌지를 모름.
 * -> 얘도 되지만 bfs가 더 빨리 찾을 수 있을 듯.
 * BFS = 주변에 있는 놈들 다 패면서 간다.
 *
 * 방문처리를 꺼내면서 해야 할 듯. 꺼내면서 하면 문제 없는 줄 알았는데, 아니였다 ㅎㅎ
 * 방문처리한 부분을 다시 지나야 하는 경우가 생김.
 * */
class Board {
    int y;
    int x;
    int dist;

    public Board(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}
public class baekjoon1987 {
    static int R, C;
    static int max = Integer.MIN_VALUE;
    static char arr[][];
    static boolean visit[][];
    static boolean alphabet[];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0 , 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visit = new boolean[R][C];
        alphabet = new boolean[26];
        for(int i=0;i<R;i++){
            arr[i] = br.readLine().toCharArray();
        }

        bfs(0, 0);
        System.out.println(max);
    }

    public static void bfs(int y, int x){
        Queue<Board> q = new LinkedList<>();
        q.add(new Board(y, x, 1));

        while(!q.isEmpty()){
            Board now = q.poll();
            int nowY = now.y;
            int nowX = now.x;
            int nowDist = now.dist;

            for(int i=0;i<4;i++){
                int posY = nowY + dy[i];
                int posX = nowX + dx[i];

                if(posY>=0 && posY<R && posX>=0 && posX<C
                        && !alphabet[arr[posY][posX]-65] && !visit[posY][posX]){
                    q.add(new Board(posY, posX, nowDist+1));
                    alphabet[arr[nowY][nowX]-65] = true;
                    visit[nowY][nowX] = true;
                }
            }
            max = Math.max(nowDist, max);
        }
    }
}
//import java.util.Queue;
//import java.util.Scanner;
//
//public class baekjoon1987 {
//
//    static int dx[]= {-1,0,1,0};
//    static int dy[] = {0,1,0,-1};
//    static int arr[][];
//    static boolean visit[][];
//    static int result;
//    static Queue<pos> q;
//    static int sero;
//    static int garo;
//    public static void main(String[] args) {
//        Scanner sc =new Scanner(System.in);
//        sero= sc.nextInt();
//        garo=sc.nextInt();
//        arr= new int[sero][garo];
//        visit = new boolean[sero][garo];
//        q = new LinkedList();
//        sc.nextLine();
//        result=0;
//        for(int i=0;i<sero;i++) {
//            String s= sc.nextLine();
//            for(int j=0;j<garo;j++) {
//                arr[i][j]=s.charAt(j)-'0';
//            }
//        }
//        q.add(new pos(0,0,1));
//        BFS();
//        System.out.println(result);
//
//
//    }
//    private static void BFS() {
//        while(!q.isEmpty()) {
//            pos temp = q.poll();
//            int count= temp.count;
//            if(temp.x==sero-1&&temp.y==garo-1) {
//                result=count;
//                return;
//            }
//            for(int i=0;i<4;i++) {
//                int rx= temp.x+dx[i];
//                int ry = temp.y+dy[i];
//                if(rx<0||ry<0||rx>=sero||ry>=garo) {
//                    continue;
//                }if(arr[rx][ry]==0) {
//                    continue;
//                }if(visit[rx][ry]==true) {
//                    continue;
//                }if(arr[rx][ry]==1&&visit[rx][ry]==false) {
//                    visit[rx][ry]=true;
//                    q.add(new pos(rx,ry,count+1));
//                }
//
//            }
//        }
//
//    }
//    static class pos{
//        int x;
//        int y;
//        int count;
//        pos(int x, int y, int count){
//            this.x= x;
//            this.y=y;
//            this.count=count;
//        }
//    }
//
//}
//