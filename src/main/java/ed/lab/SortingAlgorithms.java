package ed.lab;

import java.util.Random;

public class SortingAlgorithms {

    static <T extends Comparable<T>> int highPartition(T[] array, int low, int high) {
        T highPivot = array[high];
        int i = low - 1;

        for(int j = low; j <= high; j++){
            if(array[j].compareTo(highPivot) < 0){
                i++;
                T aux = array[i];
                array[i] = array[j];
                array[j] = aux;
            }
        }

        ++i;
        T aux = array[i];
        array[i] = array[high];
        array[high] = aux;

        return i;
    }

    static <T extends Comparable<T>> void highPivotQuickSortAux(T[] array, int low, int high) {
        if(low < high) {
            int pivotIdx = highPartition(array, low, high);
            highPivotQuickSortAux(array, low, pivotIdx - 1);
            highPivotQuickSortAux(array, pivotIdx + 1, high);
        }
    }


    static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        if(array.length > 0){
            highPivotQuickSortAux(array, 0, array.length - 1);
        }
    }

//-----------------------------------------------------------------------------------------------------------------

    static <T extends Comparable<T>> int lowPartition(T[] array, int low, int high) {
        T lowPivot = array[low];
        int i = low;

        for(int j = low + 1; j <= high; j++){
            if(array[j].compareTo(lowPivot) < 0){
                i++;
                T aux = array[i];
                array[i] = array[j];
                array[j] = aux;
            }
        }

        T aux = array[i];
        array[i] = array[low];
        array[low] = aux;

        return i;
    }

    static private <T extends Comparable<T>> void lowPivotQuickSortAux(T[] array, int low, int high) {
        if(low < high) {
            int pivotIdx = lowPartition(array, low, high);
            lowPivotQuickSortAux(array, low, pivotIdx - 1);
            lowPivotQuickSortAux(array, pivotIdx + 1, high);
        }
    }

    static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        if(array.length > 0){
            lowPivotQuickSortAux(array, 0, array.length - 1);
        }
    }

    //-----------------------------------------------------------------------------------------------------------------

    static <T extends Comparable<T>> int randomPartition(T[] array, int low, int high) {
        Random random = new Random();
        int randomIndex = low + random.nextInt(high - low + 1);
        T temp = array[low];
        array[low] = array[randomIndex];
        array[randomIndex] = temp;

        T randomPivot = array[low];
        int i = low;

        for(int j = low + 1; j <= high; j++){
            if(array[j].compareTo(randomPivot) < 0){
                i++;
                T aux = array[i];
                array[i] = array[j];
                array[j] = aux;
            }
        }

        T aux = array[i];
        array[i] = array[low];
        array[low] = aux;

        return i;
    }

    static private <T extends Comparable<T>> void randomPivotQuickSortAux(T[] array, int low, int high) {
        if(low < high) {
            int pivotIdx = randomPartition(array, low, high);
            randomPivotQuickSortAux(array, low, pivotIdx - 1);
            randomPivotQuickSortAux(array, pivotIdx + 1, high);
        }
    }

    static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        if(array.length > 0){
            randomPivotQuickSortAux(array, 0, array.length - 1);
        }
    }

}



