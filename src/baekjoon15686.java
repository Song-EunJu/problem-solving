import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Location {
    int y;
    int x;

    public Location(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class baekjoon15686 {
    static int n;
    static int m;
    static int arr[][];
    static List<Location> chickens;
    static List<Location> houses;
    static boolean visited[];

    static int finalSum = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        /**
         * 폐업시키지 않을 애들부터 정하고 치킨거리를 구해야 하지 않을까 -> 맞음. for문 돌면서 하나씩 방문처리하고
         * 최소 (N-M)개의 치킨집을 없애버린다 == 0으로 만든다. -> 이럴 필요 없이 치킨집의 좌표만 리스트에 저장해두면 됨
         * N-M 개보다는 큰 범위 내에서 하나씩 폐업시킨다 -> 치킨집 좌표만 리스트에 저장해두고 방문처리하면서 값이 m과 동일할 때 계산 시작
         * 각집에서 가장 가까운 치킨집은 어떻게 구하는가 -> 이중 포문으로 돈다
         * -> 집이 나올때마다 BFS?
         *
         * */

        houses = new ArrayList<>();
        chickens = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) // 집
                    houses.add(new Location(i,j));
                else if(arr[i][j]  == 2) // 치킨집
                    chickens.add(new Location(i,j));
            }
        }

        visited = new boolean[chickens.size()];
        chooseChicken(0, 0);
        System.out.println(finalSum);
    }

    public static void chooseChicken(int depth, int start) {
        if (depth == m) {// 폐업시키지 않을 치킨집을 최대 M개 고른 순간!
            /**
             *  현재 집의 위치에서 가장 가까운 치킨집의 거리를 구해야 하므로.
             *  집을 하나 꺼내고, 치킨집을 다돌면서 가장 가까운 값을 min 에 넣고 (min = 한집의 최소 치킨거리)
             *  min을 모두 더한 값인 sum (=모든 집의 최소 치킨거리 합) sum 중에서도 가장 작은 finalSum 값
             */
            int sum=0;
            for(Location ho: houses){
                int hoY = ho.y;
                int hoX = ho.x;
                int min = Integer.MAX_VALUE;

                for(int j=0;j<chickens.size();j++){
                    if(visited[j]) { // 방문한 치킨집 중에서만 계산
                        int chY = chickens.get(j).y;
                        int chX = chickens.get(j).x;
                        min = Math.min(Math.abs(hoY - chY) + Math.abs(hoX - chX), min);
                    }
                }
                sum += min;
            }
            finalSum = Math.min(sum, finalSum);
            return;
        }

        for(int i=start;i<chickens.size();i++){ // 치킨집을 하나씩 방문하기
            if(!visited[i]) { // 방문하지 않은 치킨집이면
                visited[i] = true;
                chooseChicken(depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}
