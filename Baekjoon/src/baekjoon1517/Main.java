package baekjoon1517;
/*
 * @problem		버블소트(1517)
 * @url			https://www.acmicpc.net/problem/1517
 * @author		pbg0205
 */

import java.io.*;
import java.util.*;


class Main {
    private static int n;
    private static long swapCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        long[] temp = new long[n];
        long[] sorted = new long[n];

        st = new StringTokenizer(br.readLine());

        int index = 0;
        while (st.hasMoreTokens()) {
            temp[index++] = Integer.parseInt(st.nextToken());
        }

        mergetSort(sorted, temp, 0, n - 1);

        System.out.println(swapCount);
    }

    private static void mergetSort(long[] sorted, long[] temp, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergetSort(sorted, temp, low, mid);
            mergetSort(sorted, temp, mid + 1, high);
            merge(sorted, temp, low, mid, high);
            printArr(temp);
        }
    }

    private static void printArr(long[] temp) {
        for (long l : temp) {
            System.out.print(l + " ");
        }
        System.out.println();
    }

    private static void merge(long[] sorted, long[] temp, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int index = low;

        while (left <= mid && right <= high) {
            if (temp[left] <= temp[right]) {
                sorted[index] = temp[left++];
            } else {
                sorted[index] = temp[right++];
                swapCount += (mid + 1 - left);
            }
            index++;
        }

        while (left <= mid) {
            sorted[index++] = temp[left++];
        }

        while (right <= high) {
            sorted[index++] = temp[right++];
        }

        for (int i = low; i <= high; i++) {
            temp[i] = sorted[i];
        }
    }
}
