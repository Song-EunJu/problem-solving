import java.io.*;

/** 합병 정렬 */
public class baekjoon2751 {
    static int n;
    static int arr[];
    static int temp[];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        temp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergesort(0, n - 1);
        for (int i = 0; i < n; i++) {
            sb.append(arr[i] + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void mergesort(int left, int right) {
        if (left >= right) // finish divided
            return;

        int mid = (left + right) / 2;

        // divide
        mergesort(left, mid);
        mergesort(mid + 1, right);

        // conquer
        int l = left; // 왼쪽 배열의 시작점
        int m = mid + 1; // 오른쪽 배열의 시작점
        int k = left; // temp 배열의 인덱스

        while (l<=mid || m<=right) { //  while루프는 왼쪽 부분 배열을 전부 다 돌았거나 오른쪽 부분 배열을 전부다 돌때까지 반복
            if (l<=mid && m<=right) { // 왼쪽, 오른쪽 배열 모두 반복이 되고 있는 경우
                if (arr[l] > arr[m]) { // 왼쪽 배열의 요소가 더 큰 경우
                    temp[k++] = arr[m++]; // temp 에 오른쪽 배열 요소를 넣음
                } else { // 오른쪽 배열 요소가 큰 경우
                    temp[k++] = arr[l++]; // temp 에 왼쪽 배열 요소를 넣음
                }
            } else if (l<=mid && m>=right) { // 오른쪽 배열이 다 끝난 경우
                temp[k++] = arr[l++]; // temp에 왼쪽 배열 요소를 넣음
            } else { // 왼쪽 배열이 다 끝난 경우
                temp[k++] = arr[m++]; // temp에 오른쪽 배열 요소를 넣음
            }
        }
        for(int i=left;i<right+1;i++) {
            arr[i]=temp[i];
        }
    }
}
