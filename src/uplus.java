//import java.util.*;
//
//public class uplus {
//    static int dx[] = {1, -1, 0, 0};
//    static int dy[] = {0, 0, 1, -1};
//    public static void main(String[] args) {
//        /*
//        // 선수로 선발된 사람 수, 한 팀의 몸무게 합
//        // 최대한 많은 인원이 선발될 수 있도록 하는 게 우선
//
//        // weight를 두배열로 나눠야 하는데 , 각 배열의 합이 동일해야 한다
//        // 그리고 그 배열 요소의 개수가 많을 수록 좋음 == 최대한 많은 인원 선발
//
//        // 두 부분집합으로 나눈다?
//
//        1. 두 부분집합으로 나눈다
//        2. 두 부분집합의 합이 같은 애들을 고른다
//        3. 그중에서 가장 많은 선수를 선발하는 방법을 고른다
//        4. 그중에서 합이 가장 큰 애를 다시 고른다
//
//
//         */
//
//        int aPeople = n;
//        int aZombie = m;
//        while (aPeople!=0 && aZombie!=0) { // a가 텅비기 전까지
//            // 최대 인원이 p, n+m 을 p 에 맞게 잘 데려가기
//            int shipToB;
//            for(int i=0;i<=p;i++){
//
//            }
//        }
//
//        /*
//         * 아무도 죽지않고 안전하게 이동하기 위해 배를 이동시키는 최소횟수
//         * -> 안죽으려면 무조건 사람수 >= 식인종 수 여야 함. (섬이랑 배에서 모두)
//         *
//         * 1. b로 갈 배에 태울 때 사람수 >= 식인종수
//         *
//         *  b로 갈 배에 태운 후, a에 남은 사람수 >= 식인종 수라면 keep going
//         *                    a에 남은 사람수 < 식인종 수라면 return -1;
//         *
//         * 2. b에 도착했을 때 b에서의 사람수 >= 식인종 수라면 keep going
//         *                  b에서의 사람수 < 식인종 수라면 return -1;
//         *
//         * 3. a로 갈 배에 태울 때 사람 수 >= 식인종 수
//         *
//         * a로 갈 배에 태운 후, b에 남은 사람 수 >= 식인종 수라면 keep going
//         *                   b에 남은 사람수 < 식인종 수라면 return -1;
//         *
//         * 4. a에 도착했을 때, a에서의 사람수 >= 식인종 수라면 keep going
//         *                   a에서의 사람수 < 식인종 수라면 return -1;
//         *
//         * n m p result
//         * 2 2 2 5
//         * 2 2 1 -1
//         *
//         * 어디서든 n>=m 인 조건을 유지해야 함
//         * -> 최소횟수니까 최대인원을 맞춰서 데려가기
//         *
//         * 고려할 사항 : 배가 이동하려면 최소 1명 이상 탑승
//         * */
//        int n = 2;
//        int m = 2;
//        int p = 2;
//        int aPeople = 2;
//        int aZombie = 2;
//        int bPeople = 0;
//        int bZombie = 0;
//        // 처음에 사람2명 보내는 경우는 무조건 안됨!!
//
//        while (aPeople!=0 && aZombie!=0) { // a가 텅비기 전까지
//            if(bPeople==0 && bZombie==0){ // 완전 처음에는
//                // 처음에 사람 2명 보내는 경우 xxxxx
//
//                if(aPeople < p){ // 사람 수가 최대 인원보다 작은 경우
//                    for(int i=0;i<=aPeople;i++){
//                        aPeople -= i; // 사람이 안가는 만큼 좀비라도 가라
//                        aZombie -= (p-i);
//                        bPeople += i;
//                        bZombie += (p-i);
//                    }
//                }
//                else {
//
//                }
//
//                // 누가 타고 돌아올 것이냐
//                for(int i=0;i<bPeople;i++){
//
//                }
//                // b에서 a로 되돌아오기
//                if(bPeople == 0){
//                    // 되돌아올 때
//                    aZombie++;
//                    bZombie--;
//                    if(aPeople < aZombie || bPeople < bZombie)
//                        return -1; // 안전하게 이동불가
//
//                }
//
//            }
//        }
//
//
//        /* 백트래킹인가? -> 죽는 경우에 다시 되돌아와서 다른 애를
//        1) 사람2, 좀비2
//        -> 사람2명을 먼저 B로 보낸다
//        -> A로 무조건 사람1명은 와야함
//        -> 그러면 A에서 좀비2, 사람1로 사람 죽음
//
//        누군가를 보내고, 다시 A로 돌아올 때 1명을 누굴 선택하느냐 까지 고려해야 함
//
//
//        -> 사람 1명, 좀비 1명을 B로 보냄
//            -> 사람1명이 A에 돌아옴
//            -> 사람1, 좀비1 이 B로 가면 좀비2, 사람1로 사망
//
//            -> 사람1명이 A에 돌아옴
//            -> 사람2가 B로 감
//            -> B에는 사람2, 좀비1
//            -> 여기서 사람이 또 가버리면 무한루프
//            -> 좀비가 A에 갓다가 2명 좀비가 같이 돌아옴
//
//            -> 좀비1명이 A에 돌아옴
//            -> 사람1, 좀비 2로 A에서 사람 1 사망
//         */
//
//
//    }
//
//import java.util.*;
//class Solution {
//    static int dx[] = {1, -1, 0, 0};
//    static int dy[] = {0, 0, 1, -1};
//    static int arr[][];
//    static boolean visit[][];
//    static int number[];
//    static int cnt = 1;
//    public String[] solution(int[][] macaron) {
//        arr = new int[7][7]; // 배열이 맞긴 함..  다 땡겨야 하는게 문제
//        number = new int[7]; // 각 열마다 갖고 있는 마카롱 갯수
//
//        for(int i=0;i<macaron.length;i++){
//            int a = macaron[i][0]; // 몇번째 열인지
//            int b = macaron[i][1]; // 마카롱 색상
//            arr[6-number[a]][a] = b;
//            number[a]++; // a열에 있는 마카롱 개수 추가
//        }
//
//        for(int i=1;i<7;i++){
//            for(int j=1;j<7;j++){
//                if(arr[i][j]!=0){
//                    cnt = 1;
//                    while(cnt != 0){ // 터진 경우, 터지지 않은 경우 cnt = 0;
//                        visit = new boolean[7][7];
//                        if(arr[i][j]==0) // 터졌는데 그 위치가 0인 경우
//                            break;
//                        bfs(i,j, arr[i][j]);
//                    }
//                }
//            }
//        }
//
//        String[] answer = new String[6];
//        StringBuilder sb;
//        for(int i=1;i<7;i++){
//            sb = new StringBuilder();
//            for(int j=1;j<7;j++){
//                sb.append(String.valueOf(arr[i][j]));
//            }
//            answer[i-1] = sb.toString();
//        }
//        return answer;
//    }
//
//    public static void bfs(int i, int j, int color){
//        Queue<int[]> q = new LinkedList<>();
//        List<int[]> list = new ArrayList<>(); // 색이 동일한 인접한 마카롱 좌표 담을 리스트
//
//        q.add(new int[] {i,j});
//        list.add(new int[] {i,j});
//
//        while(!q.isEmpty()){
//            int[] now = q.poll();
//            int nowY = now[0];
//            int nowX = now[1];
//            visit[nowY][nowX] = true;
//
//            for(int k=0;k<4;k++) {
//                int posY = nowY + dy[k];
//                int posX = nowX + dx[k];
//                if((posY>=1 && posY<=6 && posX>=1 && posX<=6) && arr[posY][posX] == color && visit[posY][posX]==false){
//                    int[] del = {posY, posX};
//                    q.add(del);
//                    list.add(del);
//                }
//            }
//        }
//
//        if(list.size()>=3){ // 3개 이상 연결된 마카롱이면 터진다.
//            for(int k=0;k<list.size();k++){
//                int position[] = list.get(k);
//                int delY = position[0];
//                int delX = position[1];
//                arr[delY][delX] = -1;
//                number[delX]--; // 열에 있는 마카롱 개수 줄이기
//            }
//
//            for(int k=1;k<=6;k++){
//                for(int h=6;h>=1;h--){
//                    if(arr[h][k] == -1){
//                        int n = h;
//                        while(n>=1){
//                            if(arr[n][k] != -1) // -1 이 아닌 첫번째 인덱스구하기
//                                break;
//                            n--;
//                        }
//
//                        for(int m=h;m>=1;m--){
//                            arr[m][k] = (n==0) ? 0 : arr[n--][k];
//                        }
//                    }
//                }
//            }
//        } else { // 터지지 않는 경우 존재
//            cnt = 0;
//        }
//    }
//    // macaron : [떨어뜨린 열 위치 , 마카롱의 색] -> 색은 1이상 9이하
//
//    public static void print(){
//        for(int i=1;i<7;i++){
//            for(int j=1;j<7;j++){
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println("==============");
//    }
//
//    public static void numberPrint(){
//        for(int i=1;i<7;i++){
//            System.out.print(number[i]);
//        }
//        System.out.println("==============");
//    }
//}