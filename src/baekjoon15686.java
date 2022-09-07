import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 1. 폐업시키지 않을 치킨집 고르기
 * 2. 폐업시킬 치킨집은 0으로 바꾸기
 * 3. for문을 돌면서 값이 1인 애가 나오면, 그 자리에서 가장 가까운 2와의 거리를 구한다.
 *    거리를 구하면서 다 더해서 치킨거리 최솟값 출력하기
 *
 * 아 이렇게 하면 안되나 ...
 * 1. 2가 나오는 순간, 해당 2와의 거리를 다 더한다. (1인 원소들이)
 * 2. 그리고 고놈들이 가장 작은 순서대로 m개 빼고 다 0으로 바꾼다.
 * 3. 그리고 1이 나오면 가장 가까운 2를 찾아서 더한다.
 *
 */
class Location {
    int y;
    int x;
    int min;

    public Location(int y, int x, int sum) {
        this.y = y;
        this.x = x;
        this.min = sum;
    }
}

public class baekjoon15686 {
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    /**
     * dy dx
     * -1 0 상
     * 1 0 하
     * 0 -1 좌
     * 0 1 우
     */
    static int n;
    static int m;
    static int arr[][];
    static List<Location> chickens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // 폐업시키지 않을 치킨집 최대 M개 - M개만 남기고 다 0으로 만들면 됨.

        arr = new int[n][n];
        chickens = new ArrayList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ////////// 값 세팅
        chooseChicken();

        // 최대 M개
        for(int i=m;i<chickens.size();i++){ // m번 초과의 치킨집은 0으로 만들어 버림
            int y = chickens.get(i).y;
            int x = chickens.get(i).x;
            arr[y][x] = 0;
        }
        
        // 최종 프린트문
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        calculateFinal();
    }

    // 3. 그리고 1이 나오면 가장 가까운 2를 찾아서 더한다.
    public static void calculateFinal() {
        // 1. 상하좌우 계산하면서 0이면 다 넣고
        // 2. i,j
        // 어디까지 가는 최단거리는 bfs
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    System.out.println(bfs(i,j));
                }
            }
        }
    }

    public static int bfs(int y, int x) {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{y,x}); // 집일 때 큐에 넣고
        int dist = Integer.MAX_VALUE;
        int sum = 0;
        while(!q.isEmpty()){
            Integer[] popData = q.poll();
            int yy = popData[0];
            int xx = popData[1];
            System.out.println(" hello");
            for(int i=0;i<4;i++){
                int posY = dy[i] + yy;
                int posX = dx[i] + xx;
                if((posY>=0 && posY<n) && (posX>=0 && posX<n) && arr[posY][posX] == 2){
                    sum++;
                    dist = Math.min(dist, sum);
                    sum=0;
                }
                if((posY>=0 && posY<n) && (posX>=0 && posX<n) && arr[posY][posX] != 0){
                    q.add(new Integer[]{posY, posX});
                }
            }
            sum++;
        }
        System.out.println("나오긴하니");
        return dist;
    }

    public static void chooseChicken(){
        // 치킨집이 나온 경우 그 치킨집 좌표를 calculateDist 로 넘김
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 2){
                    calculateDist(i,j);
                }
            }
        }
        Collections.sort(chickens, (o1, o2) -> {
            return o1.min - o2.min;
        });
    }

    public static void calculateDist(int y, int x){
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 1){ // 특정 치킨집과 많은 집들간의 거리 합을 구한다.
                    sum += Math.abs(i-y) + Math.abs(j-x);
                }
            }
        }
        chickens.add(new Location(y,x,sum)); // 그리고 해당 좌표와 거리의 합을 리스트에 넣음
    }
}
