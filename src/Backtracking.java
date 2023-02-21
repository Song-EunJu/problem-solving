import java.util.Scanner;

public class Backtracking {
    static int N, answer;
    static boolean[] col, slash, bSlash;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new boolean[N+1]; // 열 위치 체크
        slash = new boolean[2*N+1]; // / 위치 체크
        bSlash = new boolean[2*N+1]; // \ 위치 배열
        setQueen(1);
        System.out.println(answer);
    }

    private static void setQueen(int rowNo){ // rowNo: 놓으려고 하는 퀸의 행번호
        if(rowNo == N+1) {
            answer += 1;
            return;
        }

        for(int c=1;c<=N;c++){
            if(!isAvailable(rowNo, c))
                continue;
            col[c] = slash[rowNo+c] = bSlash[rowNo-c+N] = true;
            setQueen(rowNo+1);
            col[c] = slash[rowNo+c] = bSlash[rowNo-c+N] = false;
        }
    }

    private static boolean isAvailable(int r, int c){
        return !col[c] && !slash[r+c] && !bSlash[r-c+N]; // 다 false 여야 함 (다 놓지 않은 상황)
    }
}

