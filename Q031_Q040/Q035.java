package HeadForOffer_II.Q031_Q040;

import java.util.List;

public class Q035 {
    public static void main(String[] args) {

    }


    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() >1440){
            return 0;
        }
        int [] time_log = new int[timePoints.size()];
        int i = 0;
        for (String s : timePoints){
            time_log[i] = Integer.parseInt(s.split(":")[0])*60 + Integer.parseInt(s.split(":")[1]);
            i++;
        }
        boolean time_boolean_log[] = new boolean[1440];
        for (int num:time_log){
            if (time_boolean_log[num] == true){
                return 0;
            }else {
                time_boolean_log[num] = true;
            }
        }
        int start = 1440-1;
        int end = 0;
        int ans = 1440;
        int prev = -1;
        for (int count = 0;count < 1440;count++){
            if (time_boolean_log[count] == true){
                if (prev >=0){
                    ans = Math.min(count-prev,ans);
                }
                prev = count;
                start = Math.min(start,count);
                end = Math.max(end,count);
            }
        }
        return Math.min(ans,start + 1440 - end);
    }




}
