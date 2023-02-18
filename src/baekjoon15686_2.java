import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 ** 원래 접근은 폐업할 치킨집을 조합으로 뽑고, 2차원 배열을 bfs 로 돌면서 집이 나오는 경우, 주변의 치킨집 최단거리를 구하는 식으로 했는데
 * N은 최대 50*50 인데 집의 개수는 2*N개를 넘지 않는다고 했으니 0 이 많은 배열이 됨.
 * 따라서 chicken집 좌표만 리스트에 담았는데, houses도 마찬가지로 얘도 똑같이 리스트에 좌표를 담고
 * SELECT 배열에는 선택한 치킨집 (폐업할 치킨집) 을 T/F 처리하면서 관리함
 * */
public class baekjoon15686_2 {
    static List<int[]> chickens;
    static List<int[]> houses;
    static int N, M;
    static int min;
    static boolean selected[];
    public static void main(String[] args) throws IOException {
        // 치킨 거리 : 집과 가장 가까운 치킨집 사이의 거리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 폐업시키지 않을 치킨집
        chickens = new ArrayList<>();
        houses = new ArrayList<>();
        min = Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 2)
                    chickens.add(new int[]{i,j});
                else if(num == 1)
                    houses.add(new int[]{i,j});
            }
        }
        selected = new boolean[chickens.size()];
        combination(0, 0);
        System.out.println(min);
    }

    // cnt : 폐업 시킬 치킨집
    public static void combination(int cnt, int start){
        if(cnt == chickens.size()-M){ // 폐업시킬 치킨집 (list.size()-M)개
            int sum = 0;
            for(int i=0;i<houses.size();i++){
                int y = houses.get(i)[0];
                int x = houses.get(i)[1];

                int minDist = Integer.MAX_VALUE;
                for(int j=0;j<chickens.size();j++){
                    if(selected[j]) // 폐업시킬 집은 거리 계산x
                        continue;
                    int chickenY = chickens.get(j)[0];
                    int chickenX = chickens.get(j)[1];
                    minDist = Math.min(minDist, Math.abs(chickenY-y) + Math.abs(chickenX-x));
                } // 치킨집
                sum += minDist;
                if(sum > min) // 이미 sum 이 최솟값보다 커진 경우
                    return;
            }
            min = Math.min(min, sum); // 도시의 치킨 거리가 가장 작게 되는 경우
            return;
        }

        for(int i=start;i<chickens.size();i++){ // 치킨집 방문 체크하면서
            selected[i] = true; // 폐업시킨다
            combination(cnt+1, i+1);
            selected[i] = false;
        }
    }
}

//public class Main {
//    static List<int[]> chickens;
//    static int N, M;
//    static int dy[] = {1, -1, 0, 0};
//    static int dx[] = {0, 0, 1, -1};
//    static int city[][];
//    static boolean visit[][];
//    static int min;
//    public static void main(String[] args) throws IOException {
//        // 치킨 거리 : 집과 가장 가까운 치킨집 사이의 거리
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken()); // 폐업시키지 않을 치킨집
//        city = new int[N][N];
//        chickens = new ArrayList<>();
//        min = Integer.MAX_VALUE;
//
//        for(int i=0;i<N;i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j=0;j<N;j++){
//                int num = Integer.parseInt(st.nextToken());
//                if(num == 2)
//                    chickens.add(new int[]{i,j});
//                city[i][j] = num;
//            }
//        }
//
//        combination(0, 0);
//        System.out.println(min);
//    }
//
//    // cnt : 폐업 시킬 치킨집
//    public static void combination(int cnt, int start){
//        if(cnt == chickens.size()-M){ // 폐업시킬 치킨집 (list.size()-M)개
//            int sum = 0;
//            for(int i=0;i<N;i++){
//                for(int j=0;j<N;j++){
//                    if(city[i][j] == 1) {
//                        visit = new boolean[N][N];
//                        sum += bfs(i, j);
//                        if(sum > min){ // 이미 sum 이 최솟값보다 커진 경우
//                            return;
//                        }
//                    }
//                }
//            }
//            min = Math.min(min, sum); // 도시의 치킨 거리가 가장 작게 되는 경우
//            return;
//        }
//
//        for(int i=start;i<chickens.size();i++){ // 치킨집 방문 체크하면서
//            int y = chickens.get(i)[0];
//            int x = chickens.get(i)[1];
//            city[y][x] = 0;
//            combination(cnt+1, i+1);
//            city[y][x] = 2;
//        }
//    }
//
//    public static int bfs(int y, int x){
//        Queue<int[]> q = new LinkedList <>();
//        q.add(new int[]{y, x});
//        visit[y][x] = true;
//
//        while(!q.isEmpty()){
//            int[] now = q.poll();
//            int nowY = now[0];
//            int nowX = now[1];
//
//            for(int i=0;i<4;i++){
//                int posY = nowY + dy[i];
//                int posX = nowX + dx[i];
//                if(posY>=0 && posY<N && posX>=0 && posX<N && !visit[posY][posX]) {
//                    if (city[posY][posX] == 2) {// 치킨 집인 경우 해당 집과의 치킨 거리 구하기
//                        return Math.abs(posY - y) + Math.abs(posX - x);
//                    }
//                    else {
//                        q.add(new int[]{posY, posX});
//                        visit[posY][posX] = true;
//                    }
//                }
//            }
//        }
//        return 0;
//    }
//}
