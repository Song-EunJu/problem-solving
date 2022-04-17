class Solution {
    public int solution(int n) {
        int i=2;
        while(true){
            if(n%i==1)
                return i;
            i++;
        }
    }
}