/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training.ProjectEuler;

import java.util.ArrayList;

/**
 *
 * @author Hermanos-Jimenez
 */
public class Problem2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(1);
        fibonacci.add(2);
        int tam = 2;
        long sum = 2;
        while(fibonacci.get(tam - 2) + fibonacci.get(tam - 1) < 4000000){
            fibonacci.add(fibonacci.get(tam - 2) + fibonacci.get(tam - 1));
            tam++;
            if(fibonacci.get(tam - 1) % 2 == 0) sum += fibonacci.get(tam - 1);
        }
        
        System.out.println(sum);
    }
    
}
