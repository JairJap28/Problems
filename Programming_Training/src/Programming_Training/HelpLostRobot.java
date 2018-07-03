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
public class HelpLostRobot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lea = new Scanner(System.in);
        
        int t = lea.nextInt();
        
        for(int i = 0; i < t; i++){
            int x1, y1, x2, y2;
        
            x1 = lea.nextInt();
            y1 = lea.nextInt();

            x2 = lea.nextInt();
            y2 = lea.nextInt();

            if(x1 < x2 && y1 == y2){
                System.out.println("right");
            }
            else if(x1 > x2 && y1 == y2){
                System.out.println("left");
            }
            else if(y1 < y2 && x1 == x2){
                System.out.println("up");
            }
            else if(y1 > y2 && x1 == x2){
                System.out.println("down");
            }
            else{
                System.out.println("sad");
            }
        }
    }
    
}
