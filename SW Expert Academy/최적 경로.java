import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 회사에서 출발하여 N명의 고객을 모두 방문하고 집으로 돌아오는 경로 중 가장 짧은 것만 찾으면 됨
/**
 * [완전탐색]
 *
 * 1. 회사, 집 좌표 따로 저장
 * 2. 고객들의 좌표를 배열에 저장 + 해당 배열에 방문여부까지 체크하는 변수 존재
 * 3. dfs 를 통해 배열 나열하는 경우의 수를 모두 따짐
 * ++ 이동할 때마다 거리체크한 거를 같이 sum 값으로 넘겨도 괜찮을 듯??
 *
 * */
class Customer {
    int y;
    int x;

    public Customer(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
public class test {
    static int companyY, companyX, houseY, houseX;
    static int N;
    static int min;
    static int customers[][];
    static List<Customer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++){
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            customers = new int[N][3];
            int inputs[] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            companyY = inputs[0];
            companyX = inputs[1];
            houseY = inputs[2];
            houseX = inputs[3];

            int k = 4;
            // 고객 좌표 저장
            for(int j=4;j<4+N;j++) {
                customers[j-4][0] = inputs[k];
                customers[j-4][1] = inputs[k+1];
                customers[j-4][2] = 0;
                k+=2;
            }
            dfs(0);
            System.out.println("#"+(i+1)+" "+min);
        }
    }
    public static void dfs(int num){
        if(num == N){
            int sum = 0;
            sum += Math.abs(companyY-list.get(0).y) + Math.abs(companyX-list.get(0).x);
            sum += Math.abs(houseY-list.get(N-1).y) + Math.abs(houseX-list.get(N-1).x);

            for(int i=1;i<N;i++)
                sum += Math.abs(list.get(i).y - list.get(i-1).y) + Math.abs(list.get(i).x - list.get(i-1).x);

            min = Math.min(min, sum);
            return ;
        }

        for(int i=0;i<N;i++){ // i=idx 이렇게 해버리면, 0부터 다시 방문하는 경우가 빠지게 되니까
            if(customers[i][2] == 0){ // 방문하지 않은 곳만 처리
                customers[i][2] = 1;
                Customer ct = new Customer(customers[i][0], customers[i][1]);
                list.add(ct);

                dfs(num+1);

                customers[i][2] = 0;
                list.remove(ct);
            }
        }
    }
}


/** 다른풀이 1
 * [완전탐색]
 *
 * 1. 회사, 집 좌표 따로 저장
 * 2. 고객들의 좌표를 배열에 저장 + 해당 배열에 방문여부까지 체크하는 변수 존재
 * 3. dfs 를 통해 배열 나열하는 경우의 수를 모두 따짐
 * ++ 이동할 때마다 거리체크한 거를 같이 sum 값으로 넘기면 됨
 * */
class Pos {
    int y;
    int x;

    public Pos(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
public class test {
    static Pos company;
    static Pos house;
    static int N;
    static int min;
    static Pos[] customers;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++){
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            customers = new Pos[N];
            visited = new boolean[N];
            int inputs[] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            company = new Pos(inputs[0], inputs[1]);
            house = new Pos(inputs[2], inputs[3]);

            int k = 4;
            // 고객 좌표 저장
            for(int j=4;j<4+N;j++) {
                customers[j-4] = new Pos(inputs[k], inputs[k+1]);
                k+=2;
            }
            dfs(company.y, company.x, 0, 0); // 회사에서 출발하는 거리 계산하기
            System.out.println("#"+(i+1)+" "+min);
        }
    }
    public static void dfs(int posY, int posX, int sum, int num){
        // 지금까지의 거리가 이미 구해진 경로보다 크면 더이상 확인할 필요가 없음
        if(sum > min)
            return;

        if(num == N){
            // 회사와 집 간의 거리만 더해줌
            sum += getDistance(posY, house.y, posX, house.x);
            min = Math.min(min, sum);
            return ;
        }

        for(int i=0;i<N;i++){ // i=idx 이렇게 해버리면, 0부터 다시 방문하는 경우가 빠지게 되니까
            if(!visited[i]){ // 방문하지 않은 곳만 처리
                visited[i] = true;
                int nowY = customers[i].y;
                int nowX = customers[i].x;
                dfs(nowY, nowX,sum + getDistance(posY, nowY, posX, nowX), num+1);
                visited[i] = false;
            }
        }
    }

    public static int getDistance(int y1, int y2, int x1, int x2){
        return Math.abs(y1-y2) + Math.abs(x1-x2);
    }
}

/**
 * Traveling Salesperson Problem : TSP
 * 특정 도시를 출발하여 다른 도시들을 한 번씩만 들린 후, 다시 출발한 곳으로 돌아오는 경로를 찾는 문제
 * -> 경로의 합이 최소가 되어야 함
 * -> 외판원 문제
 *
 * NP 문제는 형식적으로는, 문제를 푸는 각 단계에서 여러 가지의 가능성을 동시에 고려할 수 있는 비결정적 알고리즘(non-deterministic algorithm)으로, 다항시간 내에 문제를 해결할 수 있는 문제
 * */