package com.nalmoussa.coding.practice.sorting;

class SortUtility {
    private boolean ascendingOrder;
    private SortAlgorithm algorithm;
    private int comparisonCount;
    private int swapCount;

    SortUtility() {
        this.ascendingOrder = true;
        this.algorithm = SortAlgorithm.BUBBLE;
        this.comparisonCount = 0;
        this.swapCount = 0;
    }

    SortUtility inAscendingOrder() {
        this.ascendingOrder = true;
        return this;
    }

    SortUtility inDescendingOrder() {
        this.ascendingOrder = false;
        return this;
    }
    
    SortUtility using(SortAlgorithm algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    SortResult sort(Integer[] array) {
        if ((array == null) || (array.length == 0)) {
            throw new IllegalArgumentException("The array can't be null nor empty");
        }

        this.comparisonCount = 0;
        this.swapCount = 0;
        Integer[] result = null;
        switch (algorithm) {
            case BUBBLE:
                result = bubbleSort(array);
                break;
            case COCKTAIL_SHAKER:
                result = cocktailShakerSort(array);
                break;
            case CYCLE:
                result = cycleSort(array);
                break;
            case HEAP:
                result = heapSort(array);
                break;
            case INSERTION:
                result = insertionSort(array);
                break;
            case INTRO:
                result = introSort(array);
                break;
            case MERGE:
                result = mergeSort(array);
                break;
            case MERGE_INSERTION:
                result = mergeInsertionSort(array);
                break;
            case ODD_EVEN:
                result = oddEvenSort(array);
                break;
            case QUICK:
                result = quickSort(array);
                break;
            case SELECTION:
                result = selectionSort(array);
                break;
            case SHELL:
                result = shellSort(array);
                break;
            case SMOOTH:
                result = smoothSort(array);
                break;
            case TIM:
                result = timSort(array);
                break;
        }
        return new SortResult(comparisonCount, swapCount, result);
    }

    private Integer[] bubbleSort(Integer[] array) {
        for (int i = array.length-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (mustSwap(array[j], array[j+1])) {
                    swap(array, j, j+1);
                }
            }
        }

        return array;
    }

    private Integer[] cocktailShakerSort(Integer[] array) {
        return array;
    }

    private Integer[] cycleSort(Integer[] array) {
        int n = array.length;
        for (int cycleStart = 0; cycleStart < n - 1; cycleStart++) {
            cycleSort(array, cycleStart);
        }
        return array;
    }

    private Integer[] heapSort(Integer[] array) {
        int n = array.length;

        for (int index = n/2 - 1; index >= 0; index--) {
            heapify(array, n, index);
        }

        for (int index = n - 1; index >= 0; index--) {
            swap(array, 0, index);
            heapify(array, index, 0);
        }

        return array;
    }

    private Integer[] insertionSort(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (mustSwap(array[j-1], array[j])) {
                    swap(array, j-1, j);
                } else {
                    break;
                }
            }
        }
        return array;
    }

    private Integer[] introSort(Integer[] array) {
        return array;
    }

    private Integer[] mergeSort(Integer[] array) {
        return mergeSort(array, 0, array.length-1);
    }

    private Integer[] mergeInsertionSort(Integer[] array) {
        return array;
    }

    private Integer[] oddEvenSort(Integer[] array) {
        int n = array.length;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int index = 1; index < n - 1; index +=2) {
                if (mustSwap(array[index], array[index+1])) {
                    swap(array, index, index+1);
                    sorted = false;
                }
            }

            for (int index = 0; index < n - 1; index +=2) {
                if (mustSwap(array[index], array[index+1])) {
                    swap(array, index, index+1);
                    sorted = false;
                }
            }
        }
        return array;
    }

    private Integer[] quickSort(Integer[] array) {
        return quickSort(array, 0, array.length-1);
    }

    private Integer[] selectionSort(Integer[] array) {
        int currentIndex ;
        for (int i = 0; i < array.length; i++) {
            currentIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (mustSwap(array[currentIndex], array[j])) {
                    currentIndex = j;
                }
            }
            if (currentIndex > i) {
                swap(array, i, currentIndex);
            }
        }
        return array;
    }

    private Integer[] shellSort(Integer[] array) {
        int n = array.length;
        Integer temp;
        for (int gap = n/2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                temp = array[i];
                int j = i;
                while ((j >= gap) && (mustSwap(array[j - gap], temp))) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                if (j < i) {
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    private Integer[] smoothSort(Integer[] array) {
        return array;
    }

    private Integer[] timSort(Integer[] array) {
        return array;
    }

    //////////////////////////////////////////////////////////
    ////////////////////// Helper Methods ////////////////////
    //////////////////////////////////////////////////////////
    private boolean mustSwap(Integer number1, Integer number2) {
        comparisonCount++;
        return (ascendingOrder) ? (number2 < number1) : (number1 < number2);
    }

    private void swap(Integer[] array, int index1, int index2) {
        swapCount++;
        Integer temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private Integer[] mergeSort(Integer[] array, int index1, int index2) {
        int n = index2 - index1 + 1;
        Integer[] result;
        if (n > 1) {
            int middleIndex = index1 + n/2;
            Integer[] array1 = mergeSort(array, index1, middleIndex-1);
            Integer[] array2 = mergeSort(array, middleIndex, index2);
            result = merge(array1, array2);
        } else {
            result = new Integer[1];
            result[0] = array[index1];
        }
        return result;
    }

    private Integer[] merge(Integer[] array1, Integer[] array2) {
        int n1 = array1.length;
        int n2 = array2.length;
        int index1 = 0;
        int index2 = 0;
        int index  = 0;
        Integer[] result = new Integer[n1 + n2];

        boolean readFromArray1;
        while (index1 + index2 < n1 + n2) {
            readFromArray1 = ((index1 < n1) && (index2 == n2)) || ((index1 < n1) && (index2 < n2) && mustSwap(array2[index2], array1[index1]));
            result[index++] =  readFromArray1 ? array1[index1++] : array2[index2++];
        }

        return result;
    }

    private Integer[] quickSort(Integer[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int partitionIndex = partition(array, leftIndex, rightIndex);
            quickSort(array, leftIndex, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, rightIndex);
        }
        return array;
    }

    private int partition(Integer[] array, int leftIndex, int rightIndex) {
        int left = leftIndex;
        int right = rightIndex;
        Integer pivotItem = array[leftIndex];

        while (left < right) {
            while ((left < rightIndex) && !mustSwap(array[left], pivotItem)) {
                left++;
            }

            while ((leftIndex < right) && !mustSwap(pivotItem, array[right])) {
                right--;
            }

            if (left < right) {
                swap(array, left, right);
            }
        }

        array[leftIndex] = array[right];
        array[right] = pivotItem;
        return right;
    }

    private void heapify(Integer[] array, int n, int index) {
        int parentIndex = index;
        int leftChildIndex  = 2*index + 1;
        int rightChildIndex = 2*index + 2;

        if ((leftChildIndex < n) && mustSwap(array[leftChildIndex], array[parentIndex])) {
            parentIndex = leftChildIndex;
        }

        if ((rightChildIndex < n) && mustSwap(array[rightChildIndex], array[parentIndex])) {
            parentIndex = rightChildIndex;
        }

        if (parentIndex > index) {
            swap(array, parentIndex, index);
            heapify(array, n, parentIndex);
        }
    }

    private void cycleSort(Integer[] array, int cycleStart) {
        int n = array.length;
        Integer value = array[cycleStart];
        Integer temp;
        int nextPosition = -1;
        while (nextPosition != cycleStart) {
            nextPosition = cycleStart;
            for (int i = cycleStart + 1; i < n; i++) {
                if (mustSwap(value, array[i])) {
                    nextPosition++;
                }
            }

            while ((nextPosition > cycleStart) && (value.equals(array[nextPosition]))) {
                nextPosition++;
            }

            temp = array[nextPosition];
            array[nextPosition] = value;
            value = temp;
        }
    }
}
