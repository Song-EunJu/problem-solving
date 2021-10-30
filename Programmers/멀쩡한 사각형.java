class Solution {
    public long solution(int w,int h) {
        int gcdnum = gcd(w, h);
        long result = (long)w * (long)h - ((long)w/gcdnum + (long)h/gcdnum - 1)*gcdnum;
        return result;
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