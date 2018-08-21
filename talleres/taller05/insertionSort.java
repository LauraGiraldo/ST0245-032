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
