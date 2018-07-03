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
public class Life_the_Universe_and_Everything {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lea = new Scanner(System.in);
        
        int n = lea.nextInt();
        while(n != 42){
            System.out.println(n);
            n = lea.nextInt();
        }
    }
}
