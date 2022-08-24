package Algorithm.BinarySearch;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = {0, 2, 2, 2, 3, 4, 5};
        System.out.println(getUpperBound(arr, 2));
        System.out.println(getLowerBound(arr, 2));
    }

    static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while(low <= high) {
            mid = low + (high - low) / 2;

            if(key == arr[mid]) return mid;
            else if(key > arr[mid]) low = mid + 1;
            else if (key < arr[mid]) high = mid - 1;
        }
        return -1;
    }

    static int getLowerBound(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while(low < high) {
            mid = low + (high - low) / 2;

            if(key <= arr[mid]) high = mid;
            else if(key > arr[mid]) low = mid + 1;
        }
        return low;
    }

    static int getUpperBound(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while(low < high) {
            mid = low + (high - low) / 2;

            if(key < arr[mid]) high = mid;
            else if(key >= arr[mid]) low = mid + 1;
        }
        return low;
    }
}