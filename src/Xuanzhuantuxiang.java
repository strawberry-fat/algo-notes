/**
 *  旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 */
public class Xuanzhuantuxiang {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotateprint(matrix);
    }
    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length ; i++){
            for (int j = 0 ; j <matrix.length;j++){
                
            }
        }
    }
    public static void rotateprint(int[][] matrix) {
            for (int i = 0; i < matrix.length ; i++){
                for (int j = 0 ; j <matrix.length;j++){
                    System.out.print("["+matrix[i][j]+"]");
                }
                System.out.println("");
            }
    }
}
