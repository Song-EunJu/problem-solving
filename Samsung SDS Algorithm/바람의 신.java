/**
 [생각의 흐름]
 K번의 바람을 보냈을 때, 사람이 가장 많은 구역의 사람 수를 구한다.
 -> <동서남북> 이 있는데 K 번을 구하려면 4의 K제곱 번의 경우의 수가 존재한다

 -> 4의 K 제곱번을 다 돌면서 MAX 값을 구하는 것이 맞는가
 -> 그렇다면 최선의 선택을 하는 그리디가 맞는가
 -> 그리디는 한번의 선택이 다음 선택에 무관한 값이어야 하며, 매 순간의 최적해가 문제에 대한 최적해여야 한다
 -> 근데 이 문제는 한번 옮겼을 때의 해가 문제에 대한 최적해가 될 수 없지 않을까 싶다
 -> 일단 값들을 모으는게 우선일 것 같은데,,
 -> 완탐 (브루트 포스) 는 너무 멍청한 방법인 거 같고 DP 인것일까
 -> 같은 조합이어도 순서에 따라 다른 경우가 나온다
 -> 그러면 중복 조합이 아니라 중복 순열이어야 함
 */
import java.util.*;
import java.io.*;
public class Main {
    static int[][] arr;
    static int[][] temp;
    static int[] target = new int[] {1,2,3,4}; // 순서대로 동,서,북,남
    static int[] result; // K 개의 방향 순서 담은 배열
    static int N,M,K;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 테스트 수행횟수
        for(int k=0;k<T;k++){
            max = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            result = new int[K];

            arr = new int[N][M]; // 계산할 때마다 값이 변할 배열
            temp = new int[N][M]; // 원본배열

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    int num = Integer.parseInt(st.nextToken());
                    arr[i][j] = num;
                    temp[i][j] = num;
                }
            }
            permutation(0);
            sb.append("#"+(k+1)+" "+max+"\n");
        }
        System.out.print(sb.toString());
    }

    public static void permutation(int cnt){
        if(cnt == K){
            // 첫 계산이 아니라면, 이전에 계산한 값이 arr 배열에 있으니까 다시 원본 배열 값 복사
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    arr[i][j] = temp[i][j];
                }
            }

            for(int k=0;k<K;k++){
                if(result[k] == 1){ // 동->서 (동풍)
                    for(int i=0;i<N;i++){
                        for(int j=M-1;j>=0;j--){
                            if(arr[i][j]!=0){ // 0이 아닌 경우
                                if(j-1 >= 0){ //j-1도 0이상인 경우
                                    arr[i][j-1] += arr[i][j];
                                    arr[i][j] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                else if(result[k] == 2){ // 서->동 (서풍)
                    for(int i=0;i<N;i++){
                        for(int j=0;j<M;j++){
                            if(arr[i][j]!=0){ // 0이 아닌 경우
                                if(j+1 < M){
                                    arr[i][j+1] += arr[i][j];
                                    arr[i][j] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                else if(result[k] == 3){ // 북->남 (북풍)
                    for(int j=0;j<M;j++){
                        for(int i=0;i<N;i++){
                            if(arr[i][j]!=0){ // 0이 아닌 경우
                                if(i+1 < N){
                                    arr[i+1][j] += arr[i][j];
                                    arr[i][j] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                else if(result[k] == 4){ // 남->북 (남풍)
                    for(int j=0;j<M;j++){
                        for(int i=N-1;i>=0;i--){
                            if(arr[i][j]!=0){ // 0이 아닌 경우
                                if(i-1 >= 0){
                                    arr[i-1][j] += arr[i][j];
                                    arr[i][j] = 0;
                                    break;
                                }

                            }
                        }
                    }
                }
            }

            // for문을 돌면서 가장 큰 합계 값을 구하기
            int thisMax = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(arr[i][j] > thisMax)
                        thisMax = arr[i][j];
                }
            }
            max = Math.max(max, thisMax);
            return;
        }

        for(int k=0;k<target.length;k++){
            result[cnt] = target[k]; // 선택한 방향 값을 result 배열에 푸시
            permutation(cnt+1);
        }
    }
}
