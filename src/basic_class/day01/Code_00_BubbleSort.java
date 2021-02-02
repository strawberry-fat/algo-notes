package basic_class.day01;

import java.util.Arrays;

/**
 * 冒泡排序，以及对数器的使用。
 * 对数器：
 *0，有一个你想要测的方法a，
 * 1，实现一个绝对正确但是复杂度不好的方法b，
 * 2，实现一个随机样本产生器
 * 3，实现比对的方法
 * 4，把方法a和方法b比对很多次来验证方法a是否正确。
 * 5，如果有一个样本使得比对出错，打印样本分析是哪个方法出 错
 * 6，当样本数量很多时比对测试依然正确，可以确定方法a已经 正确。
 */
public class Code_00_BubbleSort {
    public static void main(String[] args){
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            bubbleSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }
    //n^2 比较  冒泡排序
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2) return;
        for (int e = arr.length -1 ; e > 0 ; e--){
            for (int i = 0 ; i < e ; i ++){
                if (arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                }
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
