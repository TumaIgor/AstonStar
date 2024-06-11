package binaryserch;

public class BubbleSort {
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        // Проходим через все числа
        do { 
            swapped = false;
            for (int i = 1; i < n; i++) {
                // Если предыдущее число больше текущего, меняем их местами
                if (array[i - 1] > array[i]) {
                    // Меняем элементы
                    int temp = array[i - 1];
                    array[i - 1] = array[i]; 
                    array[i] = temp;
                    // Устанавливаем swapped в true для следующего прохода
                    swapped = true;
                }
            }
            // Если на этом проходе не было перестановок, массив отсортирован
        } while (swapped);
    }

    public static void quickSort( int[] array, int low, int hight) { 
    	if(low < hight) {
    		int pi = partition(array, low, hight);
    		quickSort(array, low, pi - 1);
    		quickSort(array, pi + 1, hight);
    	}
    }
    private static int partition(int[] array, int low, int high) {
        // Выбираем крайний правый элемент в качестве опорного
        int pivot = array[high];

        // Точка разделения
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // Если текущий элемент меньше или равен опорному
            if (array[j] <= pivot) {
                i++;

                // Меняем элементы местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
    
    
    public static void main(String[] args) {
        int[] myArray = {64, 34, 25, 12, 22, 11, 90, 6};
        int[] myArray1 = {54, 1, 25, 12, 4, 44, 12, 9, 112, 7};
        
        System.out.println("Original array:");
        for (int value : myArray) {
            System.out.print(value + " ");
        }
        
        bubbleSort(myArray);
        
        System.out.println("\nSorted array:");
        for (int value : myArray) {
            System.out.print(value + " ");
        }
        
        System.out.println("\nOriginal array:");
        for (int value : myArray1) {
            System.out.print(value + " ");
        }
        
        quickSort(myArray1, 0, myArray1.length - 1);
        
        System.out.println("\n Sorted (quick sort) array: " );
        for (int value : myArray1) {
            System.out.print(value + " ");
        }
    }
}
