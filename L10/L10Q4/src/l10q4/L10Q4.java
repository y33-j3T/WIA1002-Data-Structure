package l10q4;

public class L10Q4 {

    public static void insertionSort(int[] arr) {

        // from the second element to the last
        for (int i = 1; i < arr.length; i++) {
            // insert arr[i] into a sorted array
            int currentElement = arr[i];
            int k;
            for (k = i - 1; k >= 0 && arr[k] > currentElement; k--) {
                arr[k + 1] = arr[k];
            }

            // insert the current element into arr[k+1]
            arr[k + 1] = currentElement;
        }

    }

    public static void main(String[] args) {
        int[] arr = {10, 34, 2, 56, 7, 67, 88, 42};
        insertionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
