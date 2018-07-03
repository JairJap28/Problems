/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training.ProjectEuler;

/**
 *
 * @author Hermanos-Jimenez
 */
public class Problem4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String pal;
        StringBuilder a = new StringBuilder();
        int bigger = 0;
        
        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j <= 999; j++) {
                pal = (i * j) + "";
                a = new StringBuilder();
                a = a.append(pal).reverse();
                if(pal.equals(a.toString()))
                    if(Integer.parseInt(pal) > bigger) bigger = Integer.parseInt(pal);
                
            }
        }
        
        System.out.println(bigger);
    }
    
    
}
