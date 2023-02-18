package ssafy_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationSwapTest {
    static int N, input[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        permutationBySwap(0);
    }

    private static void permutationBySwap(int curr) {
        if(curr == N-1) { // 맨 끝 원소를 만나는 경우에는 연산할게 없으니까 리턴
            System.out.println(Arrays.toString(input));
            return;
        }

        // 자기자신부터 뒤쪽 나머지수까지 교환
        for(int i=curr;i<N;i++) {
            swap(curr, i);
            permutationBySwap(curr+1);
            swap(i, curr);
        }
    }

    public static void swap(int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}