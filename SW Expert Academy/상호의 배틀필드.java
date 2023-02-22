import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상호의배틀필드 {
    static int flag;
    static char map[][];
    static int H, W;
    static int carY, carX;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            carY = carX = 0;
            for(int j=0;j<H;j++){
                String s = br.readLine();
                for(int k=0;k<W;k++) {
                    char ch = s.charAt(k);
                    map[j][k] = s.charAt(k);

                    /** 모든 것에 해당되지 않는 경우에 continue 해야 하므로 && 연산자 써야 함 */
                    if(!(ch == '^') && !(ch == 'v') && !(ch == '<') && !(ch == '>'))
                        continue;
                    // 1: 위, 2: 아래, 3: 왼쪽, 4: 오른쪽
                    if(ch == '^') flag = 1;
                    else if(ch == 'v') flag = 2;
                    else if(ch == '<') flag = 3;
                    else if(ch == '>') flag = 4;
                    carY = j;
                    carX = k;
                }
            }

            int N = Integer.parseInt(br.readLine());
            String op = br.readLine();
            for(int j=0;j<N;j++){
                char ch = op.charAt(j);
                switch(ch) {
                    case 'U':
                        flag = 1;
                        /** 일단 방향을 바꾸고, 한칸 위가 평지면 그 칸으로 이동해야 하니까
                         * 이동을 안하더라도 방향은 바꾸는 코드가 있어야 함
                         * */
                        map[carY][carX] = '^';
                        if (carY - 1 < 0)
                            break;
                        up();
                        break;
                    case 'D':
                        flag = 2;
                        map[carY][carX] = 'v';
                        if (carY + 1 >= H)
                            break;
                        down();
                        break;
                    case 'L':
                        flag = 3;
                        map[carY][carX] = '<';
                        if (carX - 1 < 0)
                            break;
                        left();
                        break;
                    case 'R':
                        flag = 4;
                        map[carY][carX] = '>';
                        if (carX + 1 >= W)
                            break;
                        right();
                        break;
                    case 'S':
                        shoot(carY, carX);
                }
            }
            sb.append("#"+(i+1)+" ");
            for(int j=0;j<H;j++){
                for(int k=0;k<W;k++){
                    sb.append(map[j][k]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void up(){
        /** 한칸위가 평지면 현재 칸을 . 으로 만들고, 한칸위로 이동
         * */
        if(map[carY-1][carX] == '.') {
            map[carY][carX] = '.';
            map[--carY][carX] = '^';
        }
    }

    public static void down(){
        if(map[carY+1][carX] == '.') {
            map[carY][carX] = '.';
            map[++carY][carX] = 'v';
        }
    }

    public static void left(){
        if (map[carY][carX-1] == '.') {
            map[carY][carX] = '.';
            map[carY][--carX] = '<';
        }
    }

    public static void right(){
        if(map[carY][carX+1] == '.') {
            map[carY][carX] = '.';
            map[carY][++carX] = '>';
        }
    }
    public static void shoot(int y, int x){
        if(flag == 1){ // 위
            for(int i=y-1;i>=0;i--){
                if(map[i][x]=='*') {
                    map[i][x] = '.';
                    break;
                }
                else if(map[i][x]=='#')
                    break;
            }
        }
        else if(flag == 2){ // 아래
            for(int i=y+1;i<H;i++){
                if(map[i][x]=='*') {
                    map[i][x] = '.';
                    break;
                }
                else if(map[i][x]=='#')
                    break;
            }
        }
        else if(flag == 3){ // 왼
            for(int i=x-1;i>=0;i--){
                if(map[y][i]=='*') {
                    map[y][i] = '.';
                    break;
                }
                else if(map[y][i]=='#')
                    break;
            }
        }
        else if(flag == 4){ // 오
            for(int i=x+1;i<W;i++){
                if(map[y][i]=='*') {
                    map[y][i] = '.';
                    break;
                }
                if(map[y][i]=='#')
                    break;
            }
        }
    }
}
