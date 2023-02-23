import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Bakery {
    int hour;
    int min;
    int num;

    public Bakery(int hour, int min, int num) {
        this.hour = hour;
        this.min = min;
        this.num = num;
    }
}
class skp {
    public int solution(String[] bakery_schedule, String current_time, int k) {
        StringTokenizer st;

        String curr[] = current_time.split(":");
        int currHour = Integer.parseInt(curr[0]);
        int currMin = Integer.parseInt(curr[1]);

        List<Bakery> list = new ArrayList<>();
        for(int i=0;i<bakery_schedule.length;i++){
            st = new StringTokenizer(bakery_schedule[i]);
            String[] times = st.nextToken().split(":");
            int hour = Integer.parseInt(times[0]);
            int min = Integer.parseInt(times[1]);
            int num = Integer.parseInt(st.nextToken());
            if(currHour < hour || ((currHour==hour) && currMin<=min)){
                // 시간이 더 늦거나, 시간은 같지만 분이 더 늦은 경우에 넣기
                list.add(new Bakery(hour, min, num));
            }
        }

        int result = 0;
        for(int i=0;i<list.size();i++){
            k -= list.get(i).num;
            if(k<=0){
                result = (list.get(i).hour - currHour)*60;
                result += (list.get(i).min > currMin) ? list.get(i).min-currMin : currMin;
                return result;
            }
        }
        return -1;
    }
}