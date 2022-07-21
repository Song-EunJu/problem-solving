import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class baekjoon1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeMap<String, Integer> tree = new TreeMap<>();
        for(int i=0;i<n+m;i++){
            String name = br.readLine();
            if(tree.containsKey(name))
                tree.put(name, tree.get(name)+1);
            else
                tree.put(name, 1);
        }
        List<String> keys = tree.keySet().stream().filter(key -> tree.get(key)>1).collect(Collectors.toList());
        sb.append(keys.size()+"\n");
        for(String key:keys){
           sb.append(key+"\n");
        }
        System.out.println(sb);
    }
}
