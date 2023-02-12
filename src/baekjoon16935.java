import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon16935 {
    static int arr[][];
    static int n, m, r;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int i = 0;
        while(i<r) {
            int op = Integer.parseInt(st.nextToken());
            if(op == 1)
                one();
            else if(op == 2)
                two();
            else if(op == 3)
                three();
            else if(op == 4)
                four();
            else if(op == 5)
                five();
            else if(op == 6)
                six();
            i++;
        }
        print(arr);
    }

    public static void one() {
        for(int i=0;i<n/2;i++) {
            int temp[] = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = temp;
        }
    }

    public static void two() {
        for(int i=0;i<m/2;i++) {
            for(int j=0;j<n;j++) {
                int temp = arr[j][i];
                arr[j][i] = arr[j][m-1-i];
                arr[j][m-1-i] = temp;
            }
        }
    }

    // 오른쪽으로 90도 회전
    public static void three() {
        n = (n == arr.length) ? arr[0].length : arr.length;
        m = (n == arr.length) ? arr[0].length : arr.length;
        int newArr[][] =  new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++)
                newArr[i][j] = arr[n-1-j][i];
        }
        arr = newArr;
    }

    // 왼쪽으로 90도 회전
    public static void four() {
        n = (n == arr.length) ? arr[0].length : arr.length;
        m = (n == arr.length) ? arr[0].length : arr.length;
        int newArr[][] =  new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++)
                newArr[i][j] = arr[j][m-1-i];
        }
        arr = newArr;
    }

    public static void five() {
        int newArr[][] = new int[n][m];

        for(int i=0;i<n/2;i++) {
            // 1->2
            for(int j=0;j<m/2;j++) {
                newArr[i][j+m/2] = arr[i][j];
            }

            // 2->3
            for(int j=m/2;j<m;j++) {
                newArr[i+n/2][j] = arr[i][j];
            }
        }

        for(int i=n/2;i<n;i++) {
            // 4->1
            for(int j=0;j<m/2;j++) {
                newArr[i-n/2][j] = arr[i][j];
            }

            // 3->4
            for(int j=m/2;j<m;j++) {
                newArr[i][j-m/2] = arr[i][j];
            }
        }
        arr = newArr;
    }

    public static void six() {
        int newArr[][] = new int[n][m];

        for(int i=0;i<n/2;i++) {
            // 1->4
            for(int j=0;j<m/2;j++) {
                newArr[i+n/2][j] = arr[i][j];
            }

            // 2->1
            for(int j=m/2;j<m;j++) {
                newArr[i][j-m/2] = arr[i][j];
            }
        }

        for(int i=n/2;i<n;i++) {
            // 4->3
            for(int j=0;j<m/2;j++) {
                newArr[i][j+m/2] = arr[i][j];
            }

            // 3->2
            for(int j=m/2;j<m;j++) {
                newArr[i-n/2][j] = arr[i][j];
            }
        }
        arr = newArr;
    }

    public static void print(int[][] arr) {
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}