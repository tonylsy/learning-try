package a.dataStructures.princeton;


public class MergeSort {

    public void sort(Comparable[] arr) {
        Comparable[] arr_copy = new Comparable[arr.length];
        sort(arr, arr_copy, 0, arr.length - 1);
    }

    private void sort(Comparable[] arr, Comparable[] arr_copy, int lo, int hi) {
        if (hi <= lo) return;
        int mid = (hi + lo) / 2 + 1;

        sort(arr, arr_copy, lo, mid);
        sort(arr, arr_copy, mid + 1, hi);
        merge(arr, arr_copy, lo, mid, hi);
    }

    private void merge(Comparable[] arr, Comparable[] arr_copy, int lo, int mid, int hi) {
        /* test the two part in sort*/
        assert isSort(arr, lo, mid);
        assert isSort(arr, mid, hi);

        /* get the copy of array */
        for (int i = lo; i <= hi; i++) {
            arr_copy[i] = arr[i];
        }

        int loIndex = lo, hiIdex = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (lo > mid) {
                arr[k] = arr_copy[hiIdex];
                hiIdex++;
            } else if (hiIdex > hi) {
                arr[k] = arr_copy[loIndex];
                loIndex++;
            } else if (arr_copy[loIndex].compareTo(arr_copy[hiIdex]) <= 0) {
                arr[k] = arr_copy[loIndex];
                loIndex++;
            } else if (arr_copy[loIndex].compareTo(arr_copy[hiIdex]) > 0) {
                arr[k] = arr_copy[hiIdex];
                hiIdex++;
            }
        }

        assert isSort(arr, lo, hi);
    }

    private boolean isSort(Comparable[] arr, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            if (arr[i].compareTo(arr[i++]) > 0) {
                return false;
            }
        }
        return true;
    }
}
