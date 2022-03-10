import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
            if(arr[i]<min)
                min=arr[i];
        }

        list.remove(Integer.valueOf(min));
        if(list.size()==0)
            list.add(-1);

        return list.stream().mapToInt(i->i).toArray();
    }
}