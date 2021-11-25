package com.dx.algorithmpractise.array;

public class MergeTwoOderedArray {
    public int[] firstArray;
    public int[] secondArray;

    public MergeTwoOderedArray(int[] firstArray, int[] secondArray) {
        this.firstArray = firstArray;
        this.secondArray = secondArray;
    }

    public int[] mergerTwoArray() {
        if ((firstArray == null || firstArray.length == 0) && (secondArray != null && secondArray.length != 0)) {
            return secondArray;
        }
        if ((secondArray == null || secondArray.length == 0) && (firstArray != null && firstArray.length != 0)) {
            return firstArray;
        }

        if ((firstArray == null || firstArray.length == 0) || (secondArray == null || secondArray.length == 0)) {
            return null;
        }
        int[] mergedArray = new int[firstArray.length + secondArray.length];
        int mergeredArraySize = 0;
        int iteratorIndex = 0;
        //ascending order
        if (firstArray.length > secondArray.length) {
            for (int i = 0; i < secondArray.length; i++) {
                for (int j = iteratorIndex; j < firstArray.length; j++) {
                    if (secondArray[i] > firstArray[j]) {
                        mergedArray[mergeredArraySize] = firstArray[j];
                        mergeredArraySize++;
                        //避免每次都从头开始遍历
                        iteratorIndex++;
                    } else {
                        mergedArray[mergeredArraySize] = secondArray[i];
                        //跳出当前for 循环
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < firstArray.length; i++) {
                for (int j = iteratorIndex; j < secondArray.length; j++) {
                    if (firstArray[i] > secondArray[j]) {
                        mergedArray[mergeredArraySize] = secondArray[j];
                        mergeredArraySize++;
                        //避免每次都从头开始遍历
                        iteratorIndex++;
                    } else {
                        mergedArray[mergeredArraySize] = firstArray[i];
                        //跳出当前for 循环
                        break;
                    }
                }
            }
        }

        return mergedArray;
    }
}
