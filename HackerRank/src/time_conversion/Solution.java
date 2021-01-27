package time_conversion;

public class Solution {
    static String timeConversion(String s) {
        String[] timeArr = s.split(":");
        String AM_PM = timeArr[2].substring(2,4);

        int hour = Integer.parseInt(timeArr[0]);
        int minute = Integer.parseInt(timeArr[1]);
        int second = Integer.parseInt(timeArr[2].substring(0,2));

        if(AM_PM.equals("AM") && hour == 12) {
            hour = 0;
        }

        if(AM_PM.equals("PM") && hour < 12) {
            hour += 12;
        }

        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
