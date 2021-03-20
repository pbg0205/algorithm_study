package coding_test.startup_coding_festival.problem1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] reservedTimes = new String[n][2];
        int[][] reserveTimeToNumber = new int[n][2];

        int index = 0;
        while (index < n) {
            String input = br.readLine();
            reservedTimes[index] = input.split(" ~ ");
            //System.out.println(times[index][0] + " " + times[index][1]);

            String[] start = reservedTimes[index][0].split(":");
            int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);

            String[] end = reservedTimes[index][1].split(":");
            int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);

            reserveTimeToNumber[index][0] = startTime;
            reserveTimeToNumber[index][1] = endTime;

            System.out.println("startTime = " + startTime);
            System.out.println("endTime = " + endTime);

            index++;
        }

        Set<Integer> timeSet = new LinkedHashSet<>();
        for (int i = 0; i < 60 * 24; i++) {
            boolean isAble = true;
            for (int count = 0; count < n; count++) {
                if (!isContainTime(reserveTimeToNumber[count], i)) {
                    isAble = false;
                    break;
                }
            }
            if (isAble) {
                timeSet.add(i);
            }
        }

        if (timeSet.isEmpty()) {
            System.out.println(-1);
            return;
        }

        int startNumber = 60 * 24;
        int endNumber = 0;
        for (int i = 0; i < 60 * 24; i++) {

            if (timeSet.contains(i) && Math.min(startNumber, i) == i) {
                startNumber = i;
                continue;
            }

            if (timeSet.contains(i)) {
                endNumber = i;
            }
        }

        System.out.println(startNumber + " " + endNumber);

        String startTimeToStr = convertToTime(startNumber);
        String endTimeToStr = convertToTime(endNumber);

        System.out.println(startTimeToStr + " ~ " + endTimeToStr);
    }

    private static String convertToTime(int timeMinute) {
        int hour = timeMinute / 60;
        int minute = timeMinute % 60;

        return String.format("%2s:%2s",
                hour < 10 ? "0" + hour : hour,
                minute < 10 ? "0" + minute : minute);
    }

    private static boolean isContainTime(int[] ints, int i) {
        return ints[0] <= i && i <= ints[1];
    }
}
