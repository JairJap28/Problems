/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Hermanos-Jimenez
 */
public class SmallFactorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lea = new Scanner(System.in);
        int t = lea.nextInt();
        for(int j = 0; j < t; j++){
            int n = lea.nextInt();
        
            BigInteger a = BigInteger.ONE;

            for(int i = n; i >= 1; i--){
                a = a.multiply(BigInteger.valueOf((long) i));
            }
            System.out.println(a);
        }
    }
}
