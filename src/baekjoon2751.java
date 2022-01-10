import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon2751 {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            sb.append(arr[i]+"\n");
        }
        System.out.print(sb);
    }
}

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
	public static void main(String []args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int n=Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}

		// 2. 버블정렬 : 현재 배열 요소와 그 다음 배열 요소를 비교한 다음 조건에 걸리면 교환
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}

		for(int i=0;i<n;i++) {
			sb.append(arr[i]+"\n");
		}
		System.out.print(sb);
	}
 */
