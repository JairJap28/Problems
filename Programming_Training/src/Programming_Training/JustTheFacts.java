/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training;

import java.util.Scanner;

/**
 *
 * @author Hermanos-Jimenez
 */
public class JustTheFacts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lea = new Scanner(System.in);
        
        while(lea.hasNext()){
            int n = lea.nextInt();
            int numers[] = new int[n + 5];

            long factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
                while(factorial % 10 == 0) factorial /= 10;
                factorial = factorial % 100000;
                numers[i] = (int) (factorial % 10);
            }
                
            System.out.printf("%5d -> ", n);
            System.out.println((n == 0) ? 1: numers[n]);
        }
    }
}
