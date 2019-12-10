/**
 *  旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 */
public class Xuanzhuantuxiang {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        printmatrix(matrix);
        rotate(matrix);
        printmatrix(matrix);
    }
    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        for(int i = 0;i<length/2;i++)
        {
            for(int j = i;j<length-i-1;j++)
            {
                int t = matrix[i][j];
                matrix[i][j] = matrix[length-j-1][i];
                matrix[length-j-1][i] = matrix[length-i-1][length-j-1];
                matrix[length-i-1][length-j-1] = matrix[j][length-i-1];
                matrix[j][length-i-1] = t;
            }
        }
    }
    public static void printmatrix(int[][] matrix){
        for (int i = 0 ; i < matrix.length ; i++){
         for (int j = 0 ; j < matrix.length ; j++){
             System.out.print(matrix[i][j]+",");
         }
            System.out.println();
        }
    }
}
