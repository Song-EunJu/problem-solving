import java.util.*;
class Solution {
    public HashSet<Integer> solution(String s) {
        // 앞 뒤 중괄호 떼고 각 집합 별로 쪼개진 배열 생성
        String[] before = s.substring(2, s.length()-2).split("},\\{");

        // 문자열의 길이가 짧은 순으로 정렬
        Arrays.sort(before, (o1,o2) -> {
            return o1.length() - o2.length();
        });

        // 문자열을 다 쪼개서 정수 배열로 만듦
        int[][] finalArray = new int[before.length][before.length];
        for(int i=0;i<before.length;i++){
            String str[] = before[i].split(",");
            for(int j=0;j<str.length;j++){
                finalArray[i][j] = Integer.parseInt(str[j]);
            }
        }

        // 정수 배열을 set에 넣어서 중복 제거한 후 리턴
        HashSet<Integer> set = new LinkedHashSet<>();
        for(int i=0;i<finalArray.length;i++){
            for(int j=0;j<finalArray[i].length;j++){
                if(finalArray[i][j]==0)
                    break;
                set.add(finalArray[i][j]);
            }
        }
        return set;
    }
}