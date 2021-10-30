import java.util.*;

public class Solution {
    public int solution(int n) {
        String s = Integer.toString(n);
        int sum=0;
        for(int i=0;i<s.length();i++){
            sum+=s.charAt(i)-'0';
        }
        return sum;
    }
}