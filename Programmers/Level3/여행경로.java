// 방문하는 공항 경로의 경우의 수를 구하는 문제이므로 DFS
// 방문하는 공항 경로를 배열에 담아 return


// import java.util.*;
// class Solution {
//     static List<String> routes;
//     static boolean visited[];

//     public String[] solution(String[][] tickets) {
//         String[] answer = new String[tickets.length+1];
//         visited = new boolean[tickets.length+1];
//         routes = new ArrayList<>();

//         int idx = 0;
//         System.out.println(answer.length+" "+visited.length+" "+routes.size());
//         dfs("ICN", tickets, idx);
//         for(int i=0;i<tickets.length+1;i++){
//             answer[i] = routes.get(i);
//         }

//         return answer;
//     }
//     // 의문점:: visited 배열 인덱스를 어떤 식으로 채워야 하는가???

//     public void dfs(String start, String[][] tickets, int index){
//         if(index == tickets.length){
//             routes.add(start);
//             return ;
//         }

//         // 알파벳 순서가 앞서는 경로를 어떻게 리턴하는가
//         for(int i=0;i<tickets.length;i++){
//             // start 지점이 동일하고, 그리고 그 start 지점을 방문하지 않은 경우에만!
//             if(tickets[i][0].equals(start) && visited[index] == false){
//                 visited[index] = true;
//                 routes.add(start);
//                 dfs(tickets[i][1], tickets, index+1);
//                 visited[index] = false;
//                 routes.remove(start);
//                 // icn 방문 표시 취소
//             }
//         }
//     }
// }

/*
    배열의 인덱스를 어떤식으로 구성해야 할 까 고민했는데 걔 또한 임의로 cnt 로 넘기면서 계산하면 됐음
    경로를 결국 다 구해서 정렬하고 리턴하는 게 핵심이었음
    2번 예제를 보고, 중간에 알파벳이 빠른 위치를 발견하면 어떻게 다시 돌아갈지 생각해야 할 줄 알았는데
    그거보다 쉬운 방법이..
*/
import java.util.*;
class Solution {
    boolean[] visited;
    ArrayList<String> allRoute;

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int cnt = 0;
        visited = new boolean[tickets.length];
        allRoute = new ArrayList<>();

        dfs("ICN", "ICN", tickets, cnt);

        Collections.sort(allRoute); // 알파벳 빠른 순으로 정렬하기 위해서
        answer = allRoute.get(0).split(" ");

        return answer;
    }

    public void dfs(String start, String route, String[][] tickets, int cnt){
        if(cnt == tickets.length){ // 모든 경로가 다 구해진 경우에만 allRoute 에 문자열을 채워넣음 -> 나중에 이 문자열을 정렬하고 쪼개서
            allRoute.add(route);
            return;
        }

        for(int i=0; i<tickets.length; i++){
            // start 지점이 동일하고, 그리고 그 start 지점을 방문하지 않은 경우에만 방문하도록
            if(start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
                visited[i] = false;
            }
        }
    }
}