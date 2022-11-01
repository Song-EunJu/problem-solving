import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class baekjoon3190 {
    static int board[][];
    static boolean visited[][];
    static Map<Integer, Character> map;
    static int second = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 보드의 크기
        int k = Integer.parseInt(br.readLine()); // 사과의 개수
        board = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];
        map = new LinkedHashMap<>();
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = 1;
        }

        int l = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 횟수
        for(int i=0;i<l;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);
            map.put(x, ch);
            // 게임 시작시간으로부터 x초가 끝난 후에 왼 or 오로 90도 회전시킨다.
        }
        countTime(1,1, 1, 1,1);
    }


    // X초가 끝난 뒤에 왼쪽 L 또는 오른쪽 D로 90도 방향을 회전
    // 동:1 / 남:2 / 서:3 / 북:4
    public static void countTime(int y, int x, int ty, int tx, int direction){
        visited[y][x] = visited[ty][tx] = true;
        int headY = y;
        int headX = x; // 일단 머리를 다음 칸에 위치 시킨다 -> 뱀의 머리 위치 저장
        int tailY = ty;
        int tailX = tx;

        if(direction == 1)
            headX += 1;
        else if(direction == 2)
            headY += 1;
        else if(direction == 3)
            headX -= 1;
        else if(direction == 4)
            headY -= 1;

        // 자기 자신의 몸과 부딪히는 경우
        if(visited[headY][headX] == true)
            return;

        // 범위를 벗어나는 경우
//        if()

        if(board[headY][headX] == 1) // 이동한 칸에 사과가 있다면
            board[headY][headX] = 0; // 사과가 없어지고 꼬리는 움직이지 않음
        else  // 이동한 칸에 사과가 없다면
            tailX += 1; // 몸길이 줄여서 꼬리칸 비움

        if(map.containsKey(second)){ // 뱀 방향 변환하는 경우라면
            char ch = map.get(second);

            if(direction == 1){ // 현재 방향이 1(동쪽인 경우)
                if(ch == 'L')
                    countTime(headY, headX, tailY, tailX, 4);
                else
                    countTime(headY, headX, tailY, tailX, 2);
            }
            else if(direction == 2){ // 남쪽인 경우
                if(ch == 'L')
                    countTime(headY, headX, tailY, tailX, 1);
                else
                    countTime(headY, headX, tailY, tailX, 3);
            }
            else if(direction == 3){ // 서쪽인 경우
                if(ch == 'L')
                    countTime(headY, headX, tailY, tailX, 2);
                else
                    countTime(headY, headX, tailY, tailX, 4);
            }
            else if(direction == 4) { // 북쪽인 경우
                if (ch == 'L')
                    countTime(headY, headX, tailY, tailX, 3);
                else
                    countTime(headY, headX, tailY, tailX, 1);
            }
        } // 뱀의 방향 변환을 안해도 되는 경우

        second++;
        countTime(headY, headX, tailY, tailX, direction);
//
//        if() // 벽 또는 자기자신과 몸이 부딪히면 게임 끝남
//            break;
    }
}


// 종료 조건 : 벽, 자기자신의 몸과 부딪히는 경우
