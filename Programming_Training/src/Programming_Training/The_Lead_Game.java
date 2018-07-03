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
public class The_Lead_Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lea = new Scanner(System.in);
        
        int rounds = lea.nextInt();
        
        int player1 = 0, player2 = 0;
        
        int difference1 = 0, difference2 = 0;
        
        for(int i = 0; i < rounds; i++){
            int a,b;
            a = lea.nextInt();
            b = lea.nextInt();
            
            player1 += a;
            player2 += b;
            
            if(player1 > player2){
                if(player1 - player2 > difference1){
                    difference1 = player1 - player2;
                }
            }
            else{
                if(player2 - player1 > difference2){
                    difference2 = player2 - player1;
                }
            }
        }
        if(difference1 > difference2) System.out.println("1 " + difference1);
        else System.out.println("2 " + difference2);
    }
}
