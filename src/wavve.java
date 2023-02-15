//import java.util.*;
//
//public class wavve {
//}
//import java.util.*;
//class Solution {
//    static char str[][];
//    static boolean visit[][];
//    static List<int[]> posList;
//    static char alphabet[] = new char[]{'a', 'b', 'c'};
//    static int dx[] = {1, -1, 0, 0};
//    static int dy[] = {0, 0, 1, -1};
//    static int n, m;
//    static int result;
//    public int solution(String[] grid) {
//        // ?를 a,b,c 로 바꿔서 같은 글자 가진 칸끼리 상하좌우로 전부 연결되도록 하는 모든 경우의 수
//        n = grid.length;
//        m = grid[0].length();
//
//        str = new char[n][m];
//        posList = new ArrayList<>();
//
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                char ch = grid[i].charAt(j);
//                // 물음표인 경우에 해당 좌표를 list에 저장해둔다.
//                if(ch == '?')
//                    posList.add(new int[]{i, j});
//                str[i][j] = ch;
//            }
//        }
//
//        // 순열로 만들 알파벳 배열 (? 인 곳을 모두 채워야 하니까 posList 사이즈 만큼)
//        char arr[] = new char[posList.size()];
//        result = 0;
//        permutation(0, posList.size(), arr, result);
//
//        return result;
//    }
//
//    public static void permutation(int num, int posNum, char arr[], int result){
//        // posNum : ? 인 자리 개수
//        // num : 뽑은 숫자 개수
//
//        if(num == posNum){ // ? 에 들어갈 문자를 다 뽑았을 경우에 bfs 를 돈다.
//            for(int i=0;i<posList.size();i++){
//                int[] pos = posList.get(i);
//                int y = pos[0];
//                int x = pos[1];
//                str[y][x] = arr[i];
//            }
//            visit = new boolean[n][m];
//            Set<Character> set = new HashSet<>();
//            int flag = 0;
//
//            for(int i=0;i<n;i++){
//                for(int j=0;j<m;j++){
//                    if(visit[i][j] == false){
//                        int before = set.size();
//                        set.add(str[i][j]);
//                        int after = set.size();
//                        if(before != after) {// 해당 알파벳이 안나온 경우에만 bfs 계속작동
//                            bfs(i,j);
//                        }
//                        else{ // 해당 알파벳이 이미 나온 경우
//                            flag++;
//                            break;
//                        }
//                    }
//                }
//            }
//
//            if(flag == 0)
//                result++;
//
//            return;
//        }
//
//        // 그리고 list에 넣어둔 좌표 값에 순열계산한거 하나씩 넣어봄
//        for(int i=0;i<3;i++){
//            arr[num] = alphabet[i];
//            permutation(num+1, posNum, arr, result);
//        }
//    }
//
//    public static void bfs(int y, int x){
//        Queue<int[]> q = new LinkedList<>();
//        q.add(new int[]{y, x});
//
//        while(!q.isEmpty()){
//            int nowY = q.peek()[0];
//            int nowX = q.peek()[1];
//            visit[nowY][nowX] = true;
//            q.poll();
//
//            for(int i=0;i<4;i++){
//                int posY = nowY + dy[i];
//                int posX = nowX + dx[i];
//                if(posY>=0 && posY<n && posX>=0 && posX<m && visit[posY][posX]==false){
//                    if(str[nowY][nowX] == str[posY][posX]){ // 같은 알파벳인 경우
//                        q.add(new int[]{posY, posX});
//                    }
//                }
//            }
//        }
//    }
//}