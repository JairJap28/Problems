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
public class AddTwoNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lea = new Scanner(System.in);
        
        int t = lea.nextInt();
        
        for(int i = 0; i < t; i++){
            int a = lea.nextInt();
            int b = lea.nextInt();

            System.out.println(a + b);
        }
    }
    
}
