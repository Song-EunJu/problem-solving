/*
    왼쪽 위 좌표 (-5,5) 를 (0,0) 으로 생각하는 10x10 짜리 배열을 만든다
    따라서 좌표평면의 (0,0) 좌표가 배열의 (5,5) 번째 칸이 되는 것 => startX, startY = 5

    visit[y][x][0] = 해당 좌표를 방문한적 있는지
    visit[y][x][1] =

    U: 1 + D: 4 = 5
    L: 2 + R: 3 = 5

    ex) (5,5) 지점에서 U 명령어 만나면 -> (4,5) 로 이동한다!
    visit[4][5][0] = true -> (4,5) 방문했다고 표시
    U 명령어를 통해 위치가 바뀌었으므로 visit[4][5][1] = true
    (5,5) -> (4,5) == (4,5) -> (5,5) 는 같은 경로이므로 두 경로 다 true로 만들어줘야 함
    (4,5) -> (5,5) 는 D 명령어를 만난 경우 실행되는 것이므로
    (4,5) 로 오기 전 출발 위치인 (5,5) 도 visit[5][5][5-1] = visit[5][5][4] = true 로 만들어줌
*/
class Solution {
    static boolean visit[][][] = new boolean[11][11][5];
    static int answer = 0;
    static int startX = 5;
    static int startY = 5;

    public int solution(String dirs) {
        visit[startX][startY][0] = true;
        for(int i=0;i<dirs.length();i++){
            if(dirs.charAt(i) =='U')
                check(startY-1, startX, startY, startX, 1);
            else if(dirs.charAt(i)=='D')
                check(startY+1, startX, startY, startX, 4);
            else if(dirs.charAt(i)=='L')
                check(startY, startX-1, startY, startX, 2);
            else if(dirs.charAt(i)=='R')
                check(startY, startX+1, startY, startX, 3);
        }
        return answer;
    }

    public void check(int y, int x, int pastY, int pastX, int direct){
        if(!(x>=0 && x<=10 && y>=0 && y<=10)) // 좌표평면을 넘어가는 경우
            return;

        if(visit[y][x][0] == false || visit[y][x][direct] == false){
            visit[y][x][0] = true; // 방문했다고 변경
            visit[y][x][direct] = true; // 어떤 방향에서 출발해서 도착했는지에 대한 표시
            visit[pastY][pastX][5-direct] = true; // 어떤 지점에서 어떤 방향으로 출발했는지에 대한 표시
            answer++;
        }
        startY = y;
        startX = x;
    }
}