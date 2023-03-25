import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {
        long totalStartTime = System.currentTimeMillis();


        // Reading the array numbers from file
        long readingStartTime = System.currentTimeMillis();

        int[] arr = readArrayFromFile("input");

        long readingEndTime = System.currentTimeMillis();
        long readingTotalTime = readingEndTime - readingStartTime;


        // Sorting the array
        long sortingStartTime = System.currentTimeMillis();

        mergeSort(arr, 0, arr.length - 1);

        long sortingEndTime = System.currentTimeMillis();
        long sortingTotalTime = sortingEndTime - sortingStartTime;


        // Printing the details to the console
        System.out.println("Successfully sorted the array \n");
        System.out.println("READING the numbers from file: " + readingTotalTime + " milliseconds");
        System.out.println("SORTING the numbers: " + sortingTotalTime + " milliseconds");

        long totalEndTime = System.currentTimeMillis();
        long totalTime = totalEndTime - totalStartTime;
        System.out.println("TOTAL program time: " + totalTime + " milliseconds");
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }
    }

    public static int[] readArrayFromFile(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            int size = scanner.nextInt();
            System.out.println("Total numbers: " + size);
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }
            scanner.close();
            return arr;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
