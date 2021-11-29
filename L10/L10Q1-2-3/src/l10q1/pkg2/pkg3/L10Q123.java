package l10q1.pkg2.pkg3;

public class L10Q123 {

    public static void selectionSortSmallest(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            // find minimum in the arr[i...arr.length-1]
            int currentMin = arr[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (currentMin > arr[j]) {
                    currentMin = arr[j];
                    currentMinIndex = j;
                }
            }

            // swap arr[i] with arr[currentMinIndex] if necessary
            if (currentMinIndex != i) {
                arr[currentMinIndex] = arr[i];
                arr[i] = currentMin;
            }
        }
    }

    public static void selectionSortLargest(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            // find maximum in the arr[i...arr.length-1]
            int currentMax = arr[i];
            int currentMaxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (currentMax < arr[j]) {
                    currentMax = arr[j];
                    currentMaxIndex = j;
                }
            }

            // swap arr[i] with arr[currentMaxIndex] if necessary
            if (currentMaxIndex != i) {
                arr[currentMaxIndex] = arr[i];
                arr[i] = currentMax;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {56, 7, 2, 8, 19, 3};

        selectionSortSmallest(arr);
        for (int i : arr) {
            System.out.println(i);
        }

        selectionSortLargest(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
