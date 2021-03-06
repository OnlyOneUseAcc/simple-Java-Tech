package OnlyOneUseAcc.first;

/**
 * Class for practice with arrays
 * sort array by mergesort
 */
public class WorkWithArray {

    /**
     * Merge two parts of array
     *
     * @param arr array of numbers
     * @param l left index
     * @param m mid index
     * @param r right index
     */
    private static void merge(int[] arr, int l, int m, int r) {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 =  r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (j = 0; j < n2; j++) {
            right[j] = arr[m + 1 + j];
        }
        i = 0;
        j = 0;
        k = l;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    /**
     * Recursive part of merge sort
     * @param arr array
     * @param l left index
     * @param r right index
     */
    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    /**
     * Static method for sorting array
      * @param mas array
     */
    public static void arraySort(int[] mas) {
        if (mas == null || mas.length <= 1) {
            return;
        }
        mergeSort(mas, 0, mas.length - 1);
    }

    public static void main(String[] args) {
        int[] mas = {12, 43, 12, -65, 778, 123, 32, 76};
        arraySort(mas);
        for (int value : mas) {
            System.out.print(value + " ");
        }

    }
}
