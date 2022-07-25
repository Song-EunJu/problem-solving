import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 거의 규칙찾기 문제같음 ........ 그리고 난 규칙을 못찾음......
 * 가장 긴 가로/세로의 로직은 찾음 : 1,2중에 가장 큰 값 (가로 MAX) / 3,4 중에 가장 큰 값 (세로MAX)
 * 가장 짧은 가로/세로 로직이 문제임
 * - 가장 긴 가로 옆에 위치한 세로들의 차 절댓값 : minHeight
 * - 가장 긴 세로 옆에 위치한 가로들의 차 절댓값 : minWidth
 * 근데 이게 360도 빙글빙글 돌 수 있으므로 인덱스 계산 제대로 해줘야 함.
 * 따라서 가장 긴 가로, 세로의 인덱스를 각각 저장한 뒤 앞뒤의 원소 차이를 구해줘야 함
 * */
public class baekjoon2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int arr[][] = new int[6][2];
        int maxWidth = -1;
        int maxHeight = -1;
        int maxWidthIdx = -1;
        int maxHeightIdx = -1;

        int minWidth, minHeight;

        for(int i=0;i<6;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            if(arr[i][0] == 1 || arr[i][0] == 2) {// 1,2 중에 제일 큰 값 (가장 긴 가로)
                if(maxWidth<arr[i][1]){
                    maxWidth = arr[i][1];
                    maxWidthIdx = i;
                }
            }
            else if(arr[i][0] == 3 || arr[i][0] == 4) { // 3,4 중에 제일 큰 값 (가장 긴 세로)
                if(maxHeight<arr[i][1]) {
                    maxHeight = arr[i][1];
                    maxHeightIdx = i;
                }
            }
        }

        // 가장 긴 가로 옆에 위치한 세로들의 차 절댓값 : minHeight
        // 가장 긴 세로 옆에 위치한 가로들의 차 절댓값 : minWidth
        if(maxWidthIdx == 0){
            minHeight = Math.abs(arr[5][1]-arr[1][1]);
        }
        else if(maxWidthIdx == 5){
            minHeight = Math.abs(arr[4][1]-arr[0][1]);
        }
        else {
            minHeight = Math.abs(arr[maxWidthIdx-1][1]-arr[maxWidthIdx+1][1]);
        }


        if(maxHeightIdx == 0){
            minWidth = Math.abs(arr[5][1]-arr[1][1]);
        }
        else if(maxHeightIdx == 5){
            minWidth = Math.abs(arr[4][1]-arr[0][1]);
        }
        else {
            minWidth = Math.abs(arr[maxHeightIdx-1][1]-arr[maxHeightIdx+1][1]);
        }

        System.out.println(k*(maxWidth*maxHeight - minWidth*minHeight));
    }
}
