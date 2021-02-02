package basic_class.day01;

import java.util.Arrays;

/**
 * 归并排序
 */
public class Code_05_MergeSort {
    public static void main(String[] args){
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }
    //归并排序
    public static void mergeSort(int[] arr){
        if (arr == null || arr.length <2) return;
        mergeSort(arr,0,arr.length - 1);
    }
    public static void mergeSort(int[] arr,int l, int r ){
        if(l == r) return;
        //获取数组最中间的下标，公式为：l + (r-l)/2
        int mid = l + ((r-l) >>1);
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        //合并数组
        merge(arr,l,mid,r);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int [] help = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = m+1;

        while(p1 <= m && p2 <=r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++]:arr[p2++];
        }
        //合并数组中被剩下的。
        while(p1 <=m ) {
            help[i++] = arr[p1++];
        }
        while(p2 <= r) {
            help[i++] = arr[p2++];
        }
        //将排序好的数组覆盖到原数组中,覆盖原数组的下标范围为 [l,r]，
        for(int j = 0 ; j < help.length ; j++){
            arr[j+l] =  help[j];
        }
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
