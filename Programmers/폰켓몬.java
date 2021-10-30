import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hash = new HashSet<Integer>();

        for(int num : nums){
            hash.add(num);
        }

        if(nums.length/2<hash.size())
            return nums.length/2;
        else
            return hash.size();
    }
}