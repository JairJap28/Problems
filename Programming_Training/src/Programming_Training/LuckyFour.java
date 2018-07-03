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
public class LuckyFour {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lea = new Scanner (System.in);
        
        int t = lea.nextInt();
        
        for(int i = 0; i < t; i++){
            long n = lea.nextLong();
            long counter = 0;
            while(n != 0){
                int aux = (int) (n % 10);
                n /= 10;
                if(aux == 4) counter++;
            }
            System.out.println(counter);
        }
    }
}
