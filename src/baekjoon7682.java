import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 예제 출력을 이해하지 못하고,, 반례를 못찾아서 오래걸린문제
 1. X 빙고만 있는 경우
 - X 개수가 O의 개수보다 1개 더 많아야 함
 2. O 빙고만 있는 경우
 - X, O의 개수가 동일해야 함
 3. X, O 빙고가 모두 있는 경우 -> 불가능한 경우
 4. 빙고가 없는 경우 -> 모든 칸이 채워져 있는 것이 유일한 종료 조건
 *  */
public class baekjoon7682 {
    static Character chess[][];
    static int empty = 0;
    static int x = 0;
    static int o = 0;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String str = br.readLine();
            if(str.equals("end"))
                break;
            fillArray(str);
            validateArray(chess);
            sb.append("\n");
            empty = x = o = 0;
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }

    public static void fillArray(String str){
        chess = new Character[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                char ch = str.charAt(i*3+j);
                if(ch == '.') empty++;
                else if(ch == 'X') x++;
                else if(ch == 'O') o++;
                chess[i][j] = ch;
            }
        }
    }

    public static void validateArray(Character[][] chess){
        int status = bingo(chess);
        if(status == 1){ // X 빙고만 있는 경우
            if(x == o+1) // x빙고가 있는 경우에는 o의 개수보다 1개 많은 경우에만 성립
                sb.append("valid");
            else
                sb.append("invalid");
        }
        else if(status == 2){ // O 빙고가 있는 경우
            if(x == o) // o빙고가 있는 경우에는 x와 o 가 같아야 성립
                sb.append("valid");
            else
                sb.append("invalid");
        }
        else if(status == 3) // 빙고가 둘다 있는 경우 무조건 성립x
            sb.append("invalid");
        else { // 빙고가 없는 경우
            if(x == o+1 && x+o==9) // 빙고가 없는 경우의 유일한 종료조선 : 게임판이 가득차는것
                sb.append("valid");
            else
                sb.append("invalid");
        }
    }

    // 1 - X 빙고  / 2 - O 빙고
    public static int bingo(Character[][] chess){
        int diagSum = 0;
        int diagRSum = 0;

        int xBingo = 0;
        int oBingo = 0;
        for(int i=0;i<3;i++){
            int rowSum = 0; // 가로 빙고 계산
            int colSum = 0; // 세로 빙고 계산

            for(int j=0;j<3;j++){
                rowSum += chess[i][j];
                colSum += chess[j][i];
            }
            diagSum += chess[i][i];
            diagRSum += chess[i][2-i];

            if(rowSum == 264 || colSum == 264)
                xBingo++;
            else if(rowSum == 237 || colSum == 237)
                oBingo++;
        }

        if(diagSum == 264 || diagRSum == 264) // x 대각선 빙고가 있는 경우
            xBingo++;
        else if(diagSum == 237 || diagRSum == 237)  // o 대각선 빙고가 있는 경우
            oBingo++;

        if(xBingo > 0 && oBingo == 0)
            return 1;
        else if(xBingo == 0 && oBingo > 0)
            return 2;
        else if(xBingo > 0 && oBingo > 0) // 빙고가 둘다 있는 경우
            return 3;
        else // 빙고가 없는 경우
            return 0;
    }
}
