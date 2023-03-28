import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class baekjoon5052 {
	public static void main(String[] args) throws IOException {
		// 일관성을 유지하려면 한 번호가 다른 번호의 접두어인 경우가 없어야 함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			String[] phones = new String[N];
			for(int j=0;j<N;j++) {
				phones[j] = br.readLine();
			}
			
			// 정렬하고 나면 접두어가 될 수 있는 애가 무조건 앞에 오게 되니까, 비교가 가능해짐
			Arrays.sort(phones); 
			boolean flag = false;
			for(int j=0;j<N-1;j++) {
				if(phones[j+1].startsWith(phones[j])) {
					sb.append("NO\n");
					flag = true;
					break;
				}
			}
			if(!flag)
				sb.append("YES\n");
		}
		System.out.print(sb);
	}
}
