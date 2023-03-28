import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class baekjoon11656 {

	// 모든 접미사를 사전순으로 정렬한 후 출력
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		s.substring(s.length()-1, s.length());
		List<String> list = new ArrayList<>();
		for(int i=1;i<=s.length();i++) {
			list.add(s.substring(s.length()-i, s.length()));
		}
		Collections.sort(list);
		
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i)+"\n");
		}
		System.out.println(sb);
	}
}
