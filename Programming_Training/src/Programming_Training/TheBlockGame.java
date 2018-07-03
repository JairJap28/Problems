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
public class TheBlockGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lea = new Scanner(System.in);
        
        int t = lea.nextInt();
        
        
        for(int i = 0; i < t; i++){
            int n = lea.nextInt();
            
            StringBuilder sB = new StringBuilder();
            StringBuilder sA = new StringBuilder();
            sA.append(n);
            sB.append(sA).reverse();
            
            if(sA.toString().equals(sB.toString())){
                System.out.println("wins");
            }
            else{
                System.out.println("losses");
            }
        }
    }
    
}
