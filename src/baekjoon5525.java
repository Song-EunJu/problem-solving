//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class baekjoon5525 {
//	public static void main(String[] args)  throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int M = Integer.parseInt(br.readLine());
//		String str = br.readLine();
//		String compareStr = "IO".repeat(N)+"I";
//		int i=0;
//		int cnt = 0;
//		while(i<=M) {
//			int idx = str.indexOf(compareStr, i);
//			if(idx != -1) { // 인덱스가 있는 경우
//				cnt++;
//				i = idx; // 해당인덱스 자리로 가서
//			}
//			i+=2; // 해당인덱스+2 자리에서 시작, 왜냐면 인덱스가 있는거면 IO 형태니까 O 자리 지나서 I에서 시작해야 함
//		}
//
//		// P(N) 이 몇군데 포함되어 있는가??
//		System.out.println(cnt);
//	}
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon5525 {
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int cnt = 0;
		int result = 0;
		for(int i=1;i<M;i++){
			char ch1 = str.charAt(i-1);
			char ch2 = str.charAt(i);
			char ch3 = str.charAt(i+1);

			if(ch1 == 'I' && ch2 == 'O' && ch3 == 'I'){
				cnt++;

				if(cnt == N){

				}
			}
		}

//		while(i<=M) {
//			int idx = str.indexOf(compareStr, i);
//			if(idx != -1) { // 인덱스가 있는 경우
//				cnt++;
//				i = idx; // 해당인덱스 자리로 가서
//			}
//			i+=2; // 해당인덱스+2 자리에서 시작, 왜냐면 인덱스가 있는거면 IO 형태니까 O 자리 지나서 I에서 시작해야 함
//		}

		// P(N) 이 몇군데 포함되어 있는가??
		System.out.println(result);
	}
}
