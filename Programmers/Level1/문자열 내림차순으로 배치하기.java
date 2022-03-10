import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> list = new ArrayList<>();

        // char []ch = new char[s.length()];
        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
        }

        Collections.sort(list, (o1,o2)-> o2.compareTo(o1));

        for(Character ch : list)
            sb.append(ch);

        return sb.toString();
    }
}