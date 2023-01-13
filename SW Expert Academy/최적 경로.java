import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 회사에서 출발하여 N명의 고객을 모두 방문하고 집으로 돌아오는 경로 중 가장 짧은 것만 찾으면 됨
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
