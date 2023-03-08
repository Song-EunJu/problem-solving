public class testjava {
    static boolean visited[] = new boolean[4];
    static int point[] = new int[]{1,2,3,4};
    public static void main(String[] args) {
        dfs(0);
    }

    public static void dfs(int n){
        if(n == point.length-1){
            return;
        }
        for(int i=0;i<visited.length;i++){
            if(visited[i] == false)
                System.out.print(point[i]+" ");
        }
        System.out.println();
        for(int i=0;i<visited.length;i++){
            if(visited[i] == true)
                System.out.print(point[i]+" ");
        }
        System.out.println();
        System.out.println("================");
        visited[n] = true;
        dfs(n+1);
        visited[n] = false;
    }
}
