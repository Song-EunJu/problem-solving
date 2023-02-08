import java.util.Scanner;

// 조합 (중복X, 순서가 중요하지 않은)
public class baekjoon15650 {

    static int n,m;
    static int numbers[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        numbers = new int[m];
        combination(0, 1);
    }

    public static void combination(int cnt, int idx) {
        // 재귀가 도는 횟수 : cnt
        if(cnt == m) {
            for(int i=0;i<m;i++) {
                System.out.print(numbers[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=idx;i<=n;i++) {
            numbers[cnt] = i;
            combination(cnt+1, i+1);
        }
    }

}