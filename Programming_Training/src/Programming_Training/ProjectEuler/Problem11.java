/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training.ProjectEuler;

import java.util.Scanner;

/**
 *
 * @author Hermanos-Jimenez
 */
public class Problem11 {

    static int numbers[][];
    /**
     * @param args the command line arguments
     */
    
    static int a = 0;
    static int b = 0;
    static int c = 0;
    static int d = 0;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lea = new Scanner(System.in);
        numbers = new int[20][20];
        
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                numbers[i][j] = lea.nextInt();
            }
        }
        
        System.out.println(checkUp());
        System.out.println(a + " " + b + " " + c + " " + d);
        System.out.println(checkRight());
        System.out.println(a + " " + b + " " + c + " " + d);
        System.out.println(checkDiagonalRight());
        System.out.println(a + " " + b + " " + c + " " + d);
        System.out.println(checkDiagonalLeft());
        System.out.println(a + " " + b + " " + c + " " + d);

        
    }
    
    
    static long checkUp(){
        long product = 0;
        
        for (int j = 0; j < 20; j++) {
            for (int i = 19; i >= 3; i--) {
                if(numbers[i][j] * numbers[i - 1][j] * numbers[i - 2][j] * numbers[i - 3][j] > product){
                    product = numbers[i][j] * numbers[i - 1][j] * numbers[i - 2][j] * numbers[i - 3][j];
                    a = numbers[i][j];
                        b = numbers[i - 1][j];
                        c = numbers[i - 2][j];
                        d = numbers[i - 3][j];
                }
            }
        }
        return product;
    }
    
    static long checkRight(){
        long product = 0;
        
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                try {
                    
                    if(numbers[i][j] * numbers[i][j + 1] * numbers[i][j + 2] * numbers[i][j + 3] > product){
                        product = numbers[i][j] * numbers[i][j + 1] * numbers[i][j + 2] * numbers[i][j + 3];
                        a = numbers[i][j];
                        b = numbers[i][j + 1];
                        c = numbers[i][j + 2];
                        d = numbers[i][j + 3];
                    }
                    
                } catch (Exception e) {
                }
            }
        }
        
        return product;
    }
    
    
    static long checkDiagonalRight(){
        long product = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                try {
                    
                    if(numbers[i][j] * numbers[i + 1][j + 1] * numbers[i + 2][j + 2] * numbers[i + 3][j + 3] > product){
                        product = numbers[i][j] * numbers[i + 1][j + 1] * numbers[i + 2][j + 2] * numbers[i + 3][j + 3];
                        a = numbers[i][j];
                        b = numbers[i + 1][j + 1];
                        c = numbers[i + 2][j + 2];
                        d = numbers[i + 3][j + 3];
                    }
                    
                } catch (Exception e) {
                }
            }
        }
        
        return product;
    }
    
    static long checkDiagonalLeft(){
        long product = 0;
        
        for (int i = 0; i < 20; i++) {
            for (int j = 19; j >= 0; j--) {
                try {
                    
                    if(numbers[i][j] * numbers[i + 1][j - 1] * numbers[i + 2][j - 2] * numbers[i + 3][j - 3] > product){
                        product = numbers[i][j] * numbers[i + 1][j - 1] * numbers[i + 2][j - 2] * numbers[i + 3][j - 3];
                        a = numbers[i][j];
                        b = numbers[i + 1][j - 1];
                        c = numbers[i + 2][j - 2];
                        d = numbers[i + 3][j - 3];
                    }
                    
                } catch (Exception e) {
                }
            }
        }
        
        
        
        return product;
    }
    
}
