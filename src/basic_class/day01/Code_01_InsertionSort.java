package basic_class.day01;

import java.util.Arrays;

/**
 * 插入排序
 */
public class Code_01_InsertionSort {
    public static void main(String[] args){
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            insertionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        insertionSort(arr);
        printArray(arr);
    }
    //插入排序
    public static void insertionSort(int[] arr){
        if (arr == null || arr.length <2) return;
        for (int i = 1 ; i < arr.length; i++ ){
            for (int j = i - 1; j >= 0 && arr[j] > arr[j+1] ; j-- ){
                    swap(arr,j,j+1);
            }
        }
    }
    //换位
    public static void swap (int []arr,int i ,int j){
        if (i == j) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    //绝对正确的算法
    public static void comparator (int[]arr ){
        Arrays.sort(arr);
    }
    //随机数产生
    public static int[] generateRandomArray (int maxSize,int maxValue){
        int [] arr = new int [(int) ((maxSize + 1 ) * Math.random()) ];
        for (int i = 0; i < arr.length;i++){
            arr [i] = (int) ((maxValue + 1) * Math.random()) - (int)((maxValue) * Math.random());
        }
        return arr;
    }

    // 复制数组
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // 比较器
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for 打印数组
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
