import java.io.*;
import java.util.StringTokenizer;

public class baekjoon2630 {
    static int white;
    static int blue;
    static int n;
    static int arr[][];
    static int temp;
    public static void main(String[] args) throws IOException {
        // 분할정복_문제를 나눌 수 없을 때까지 나누어서 각각을 풀면서 다시 합병하여 답을 얻는 알고리즘
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr= new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        divide(0,0);
        System.out.println(white+"\n"+blue);
    }
    static void divide(int x, int y) {
        int zero = 0;
        int one = 0;
        temp = n/2;
        if (temp == 1) {
            if (arr[x][y] == 0)
                white++;
            else
                blue++;
            return;
        }

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] == 0) // 0-> 흰색
                    zero++;
                else if (arr[i][j] == 1) // 1-> 파란색
                    one++;
            }
            if(zero!=0 && one!=0) // 같은 수가 아닌 순간 for문 빠져나옴
                break;
        }

        if(zero == 0) // 다 흰색인 경우
            white++;
        else if(one==0) // 다 파란색인 경우
            blue++;


        divide(x, y); // (0,0)
        System.out.println("x+\" \"+y = " + x+" "+y);
        divide(x, y + n); // (0,4)
        System.out.println("x+\" \"+y = " + x+" "+(y+n));
        divide(x + n, y); // (4,0)
        System.out.println("x+\" \"+y = " + (x+n)+" "+y);
        divide(x + n, y + n); // (4,4)
        System.out.println("x+\" \"+y = " + (x+n)+" "+(y+n));

    }
}
