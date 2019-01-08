public class RotateMatrix {
    
    public int[][] rotateRight(int matrix[][]){
        int copy[][] = new int[matrix.length][matrix[0].length];
        
        int width = copy.length - 1;
        
        for(int[] matrix1: matrix){ 
            for(int i = 0; i < matrix1.length; i++){
                int val = matrix1[i];
                copy[i][width] = val;
            }
            width--;
        }
        
        return copy;
        
    }
    
    public int[][] rotateLeft(int matrix[][]){
        int copy[][] = new int[matrix.length][matrix[0].length];
        
        for(int j = 0; j < matrix.length; j++){
            int heigth = copy.length - 1;
            for(int i = 0; i < matrix[j].length; i++){
                int value = matrix[j][i];
                copy[heigth][j] = value;
                heigth--;
            }
        }
        
        return copy;
        
    }
    
    public void printMatrix(int matrix[][]){
        for (int[] matrix1 : matrix) {
            for (int j = 0; j < matrix1.length; j++) {
                System.out.print(matrix1[j] + " ");
            }
            System.out.println("");
        }
    }
    
    public RotateMatrix() {
        int matrixOriginal[][]  = {{1,2,3},
                           {4,5,6},
                           {7,8,9}}; 
        
        System.out.println("Original Matrix");
        printMatrix(matrixOriginal);
        
        int matrix[][] = rotateRight(matrixOriginal);
        
        System.out.println("Rotated Matrix to Right");
        printMatrix(matrix);
        
        matrix = rotateLeft(matrixOriginal);
        System.out.println("Rotated Matrix to left");
        printMatrix(matrix);
        
    }

    public static void main(String[] args) {
        new RotateMatrix();
    }
    
}
