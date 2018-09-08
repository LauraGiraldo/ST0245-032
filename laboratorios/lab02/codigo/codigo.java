public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //merge sort
        for (int i = 1000000; i <= 20000000; i = i + 1000000) {
            int[] a = new int[i];
            for (int j = 0; j < i; j++) {
                a[j] = (int) (Math.random() * j);
            }
            long start = System.currentTimeMillis();
            merge(a, 0, a.length - 1);
            long fin = System.currentTimeMillis();
            System.out.println(fin - start);
        }
        //insertion sort
        for (int i = 10000; i <= 200000; i = i + 10000) {
            int[] a = new int[i];
            for (int j = 0; j < i; j++) {
                a[j] = (int) (Math.random() * j);
            }
            long start = System.currentTimeMillis();
            insertionSort(a);
            long fin = System.currentTimeMillis();
            System.out.println(fin - start);
        }

    }

    public static int[] insertionSort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            for (int j = i; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    int aux = a[i];
                    a[i] = min;
                    a[j] = aux;
                }
            }
        }
        return a;
    }

    public static void merge(int arr[], int l, int r) {
        int m = (l + r) / 2;
        if (l < r) {

            merge(arr, l, m);
            merge(arr, m + 1, r);
        }
        int i;
        int j;
        int k;

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }
        i = 0;
        j = 0;
        k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
