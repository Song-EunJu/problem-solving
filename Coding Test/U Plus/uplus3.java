import java.util.*;
class Solution {
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int arr[][];
    static boolean visit[][];
    static int number[];
    static int cnt = 1;
    public String[] solution(int[][] macaron) {
        arr = new int[7][7]; // 배열이 맞긴 함..  다 땡겨야 하는게 문제
        number = new int[7]; // 각 열마다 갖고 있는 마카롱 갯수

        for(int i=0;i<macaron.length;i++){
            int a = macaron[i][0]; // 몇번째 열인지
            int b = macaron[i][1]; // 마카롱 색상
            arr[6-number[a]][a] = b;
            number[a]++; // a열에 있는 마카롱 개수 추가
        }

        for(int i=1;i<7;i++){
            for(int j=1;j<7;j++){
                if(arr[i][j]!=0){
                    cnt = 1;
                    while(cnt != 0){ // 터진 경우, 터지지 않은 경우 cnt = 0;
                        visit = new boolean[7][7];
                        if(arr[i][j]==0) // 터졌는데 그 위치가 0인 경우
                            break;
                        bfs(i,j, arr[i][j]);
                    }
                }
            }
        }

        String[] answer = new String[6];
        StringBuilder sb;
        for(int i=1;i<7;i++){
            sb = new StringBuilder();
            for(int j=1;j<7;j++){
                sb.append(String.valueOf(arr[i][j]));
            }
            answer[i-1] = sb.toString();
        }
        return answer;
    }

    public static void bfs(int i, int j, int color){
        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>(); // 색이 동일한 인접한 마카롱 좌표 담을 리스트

        q.add(new int[] {i,j});
        list.add(new int[] {i,j});

        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowY = now[0];
            int nowX = now[1];
            visit[nowY][nowX] = true;

            for(int k=0;k<4;k++) {
                int posY = nowY + dy[k];
                int posX = nowX + dx[k];
                if((posY>=1 && posY<=6 && posX>=1 && posX<=6) && arr[posY][posX] == color && visit[posY][posX]==false){
                    int[] del = {posY, posX};
                    q.add(del);
                    list.add(del);
                }
            }
        }

        if(list.size()>=3){ // 3개 이상 연결된 마카롱이면 터진다.
            for(int k=0;k<list.size();k++){
                int position[] = list.get(k);
                int delY = position[0];
                int delX = position[1];
                arr[delY][delX] = -1;
                number[delX]--; // 열에 있는 마카롱 개수 줄이기
            }

            for(int k=1;k<=6;k++){
                for(int h=6;h>=1;h--){
                    if(arr[h][k] == -1){
                        int n = h;
                        while(n>=1){
                            if(arr[n][k] != -1) // -1 이 아닌 첫번째 인덱스구하기
                                break;
                            n--;
                        }

                        for(int m=h;m>=1;m--){
                            arr[m][k] = (n==0) ? 0 : arr[n--][k];
                        }
                    }
                }
            }
        } else { // 터지지 않는 경우 존재
            cnt = 0;
        }
    }
    // macaron : [떨어뜨린 열 위치 , 마카롱의 색] -> 색은 1이상 9이하

    public static void print(){
        for(int i=1;i<7;i++){
            for(int j=1;j<7;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println("==============");
    }

    public static void numberPrint(){
        for(int i=1;i<7;i++){
            System.out.print(number[i]);
        }
        System.out.println("==============");
    }
}