package sorting;

/*
 * @ Problem    K번 째 수
 * @ Url        https://programmers.co.kr/learn/courses/30/lessons/42748
 * @ Author     pbg0205
 * @ Created by 2021.01.20
 */

public class K_number {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        K_number solution = new K_number();
        int[] answer = solution.solution(arr, commands);

        for (int i : answer) {
            System.out.println(i);
        }
    }

    public int[] solution(int[] arr, int[][] commands) {
        int[] answer = new int[commands.length];
        int answer_idx = 0;

        for (int[] command : commands) {
            int start = command[0] - 1;
            int end = command[1] - 1;
            int findIndex = command[2] - 1;

            int[] tempArr = new int[end - start + 1];

            int index = 0;
            for (int i = start; i <= end; i++) {
                tempArr[index++] = arr[i];
            }

            quickSort(tempArr, 0, tempArr.length - 1);

            answer[answer_idx++] = tempArr[findIndex];
        }

        return answer;
    }

    private static void quickSort(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        int mid = (start + end) / 2;

        int pivot= arr[mid];

        do {
            while(arr[left] < pivot) {
                left++;
            }
            while(arr[right] > pivot) {
                right--;
            }

            if(left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }while(left <= right);

        if(start < right) {
            quickSort(arr, start, right);
        }

        if(end > left) {
            quickSort(arr, left, end);
        }
    }
}
