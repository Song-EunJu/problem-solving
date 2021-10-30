import java.util.*;
class Solution {
    public String solution(String s) {
        int idx=0;
        StringBuilder sb = new StringBuilder();
        String str[] = s.split("");

        for(int i=0;i<str.length;i++){
            if(str[i].equals(" ")){
                idx=0;
                sb.append(" ");
                continue;
            }

            if(idx%2==0){
                str[i]=str[i].toUpperCase();
            }
            else
                str[i]=str[i].toLowerCase();

            idx++;
            sb.append(str[i]);
        }

        return sb.toString();
    }
}