/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Hermanos-Jimenez
 */
public class LinearCellularAutomata {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lea = new Scanner(System.in);
        
        int cases = lea.nextInt();
        for (int t = 0; t < cases; t++) {
            int arrayIn[] = new int[10];
            char out[] = {' ', '.', 'x', 'W'};

            int DNA[] = new int[40];
            DNA[19] = 1;

            for (int i = 0; i < 10; i++) {
                arrayIn[i] = lea.nextInt();
            }
            for (int i = 0; i < 40; i++) {
                System.out.print(out[DNA[i]]);
            }
            System.out.println("");

            for (int j = 1; j < 50; j++) {
                int copy[] = new int[40];
                for (int i = 1; i < 39; i++) {
                    int k = DNA[i - 1] + DNA[i] + DNA[i + 1];
                    copy[i] = arrayIn[k];
                    
                }
                copy[0] = arrayIn[DNA[0] + DNA[1]];
                copy[39] = arrayIn[DNA[39] + DNA[38]];
                for (int x = 0; x < 40; x++) {
                    System.out.print(out[copy[x]]);
                }
                DNA = copy.clone();
                System.out.println("");
            }
            
            if(t < cases - 1) System.out.println("");
        }
    }
    
}
