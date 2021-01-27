package diagonal_difference;

import java.util.List;

public class Result {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int left_to_right = 0;
        int right_to_left = 0;

        int index = 0;
        while(index < arr.size()) {
            left_to_right += arr.get(index).get(index);
            right_to_left += arr.get(arr.size() - (index + 1)).get(index);
            index++;
        }
        return Math.abs(left_to_right - right_to_left);
    }
}
