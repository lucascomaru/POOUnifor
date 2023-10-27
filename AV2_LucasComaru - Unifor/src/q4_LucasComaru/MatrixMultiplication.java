package q4_LucasComaru;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MatrixMultiplication {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\lucas\\eclipse-workspace\\AV2_LucasComaru\\src\\q4_LucasComaru\\matrizes.txt";

        try {
            int[][] matrixA = readMatrixFromFile(filePath, 3, 3);
            int[][] matrixB = readMatrixFromFile(filePath, 3, 3);

            if (matrixA[0].length != matrixB.length) {
                System.out.println("As matrizes não podem ser multiplicadas.");
                return;
            }

            int[][] resultMatrix = multiplyMatrices(matrixA, matrixB);

            System.out.println("Matriz Resultante:");
            printMatrix(resultMatrix);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result;
    }

    public static int[][] readMatrixFromFile(String filePath, int rows, int cols) throws IOException {
        int[][] matrix = new int[rows][cols];
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        for (int i = 0; i < rows; i++) {
            String[] values = reader.readLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(values[j]);
            }
        }

        reader.close();
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
