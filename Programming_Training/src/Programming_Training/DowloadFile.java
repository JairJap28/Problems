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
public class DowloadFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lea = new Scanner(System.in);
        
        int cases = lea.nextInt();
        
        for(int j = 0; j < cases; j++){
            int n = lea.nextInt();
            int k = lea.nextInt();

            int t,d, counter = 0;
            for(int i = 0; i < n; i++){
                t = lea.nextInt();
                d = lea.nextInt();

                if(k > 0){
                    int aux = t;
                    if(t >= k){
                        t -= k;
                        k = 0;
                    }
                    else{
                        k = k - t;
                        t = 0;
                    }
                }
                counter += t * d;
            }

            System.out.println(counter);
        }
    }
}
