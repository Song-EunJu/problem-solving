import java.util.*;
class skp2 {
    public static void main(String[] args) {
        int[] p = {2,2,-1,1,5,-1,5};
        int[] b = {1,5};// 4,3 // 1,5 -> 0,3
        int[] ar = solution(p,b);
        for(int i=0; i<ar.length; i++){
            System.out.println(ar[i]+ " ");
        }

    }

    public static int[] solution(int[] p, int[] b) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<p.length;i++){
            if(p[i] == -1){ // 보스인 경우
                List<Integer> list = new ArrayList<>();
                while(!q.isEmpty()){
                    int remove[] = q.peek();
                    if(remove[1] == i){
                        list.add(q.poll()[0]);
                    }
                    else{
                        q.add(q.poll());
                        if(q.size() == 1)
                            break;
                    }
                }
                map.put(i, list);
            }
            else { // 보스가 아닌 경우
                if(!findParent(map, i, p[i]))
                    q.add(new int[]{i, p[i]});
                //보스의 자식도 아니고, 보스의 하위자식들의 자식도 아닌 경우 큐에 추가
            }
        }

        int result[] = new int[b.length];
        for(int i=0;i<result.length;i++){
            if(map.containsKey(b[i])){
                result[i] = map.get(b[i]).size()+1;
            }
            else result[i] = 0;
        }
        return result;
    }

    public static boolean findParent(Map<Integer, List<Integer>> map, int me, int boss){
        for(Integer key: map.keySet()) {
            if(key == boss) { // 보스 아래 바로 자식이면 map에서 꺼낸 리스트에 자식 바로 추가
                map.get(key).add(me);
                return true;
            }

            List<Integer> values = map.get(key); // 보스의 하위하위 자식인 것도 리스트에 추가
            if (values.contains(boss)) {
                map.get(key).add(me);
                return true;
            }
        }
        return false;
    }
}



