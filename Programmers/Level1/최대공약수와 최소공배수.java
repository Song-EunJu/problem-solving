class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        int a=gcd(n,m);

        // 최소공배수
        
        if(a==1){
            answer[0]=1;
            answer[1]=n*m;
        }
        else{
            answer[0]=a;
            answer[1]=a*(n/a)*(m/a);
        }

        return answer;
    }

    public int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
