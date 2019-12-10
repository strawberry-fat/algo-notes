import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字
 * 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class ClockPrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printMatrix(matrix);
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> arr = new ArrayList<>();
        int up = 0;
        int left = 0;
        int down = matrix.length - 1;
        int right = matrix[0].length - 1;
        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                arr.add(matrix[up][i]);
            }
            up++;
            for (int i = up; i <= down; i++) {
                arr.add(matrix[i][right]);
            }
            right--;
            if (up - 1 != down) {
                for (int i = right; i >= left; i--) {
                    arr.add(matrix[down][i]);
                }
            }
            down--;
            if (left != right + 1) {
                for (int i = down; i >= up; i--) {
                    arr.add(matrix[i][left]);
                }
            }
            left++;
        }
        return arr;
    }
}
