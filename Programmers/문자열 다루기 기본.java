class Solution {
    public boolean solution(String s) {
        int count=0;

        if(!(s.length()==4) && !(s.length()==6))
            return false;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch>='0' && ch<='9')
                count++;
        }

        if(count!=s.length())
            return false;
        else
            return true;
    }
}