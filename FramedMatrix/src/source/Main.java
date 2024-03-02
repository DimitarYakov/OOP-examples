/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

/**
 *
 * @author thanos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static boolean isFramed(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0 || matrix[rows - 1][j] == 0)
                return false;
        }
        
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0 || matrix[i][cols - 1] == 0)
                return false;
        }
        
        return true;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1, 1},
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {1, 1, 1, 1}
        };

        boolean isFramedMatrix = isFramed(matrix);
        System.out.println("Is the matrix framed? " + isFramedMatrix);
    }
    
}
