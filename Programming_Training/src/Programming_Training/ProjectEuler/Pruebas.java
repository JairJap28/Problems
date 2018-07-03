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
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int a = 0,b = 0,c = 0;
        
        for (int i = 1; i <= 998; i++) {
            for (int j = 1; j <= 998; j++) {
                for (int k = 1; k <= 998; k++) {
                    if((((i * i) + (j * j)) == (k * k)) && (i + j + k) == 1000){
                        a = i;
                        b = j;
                        c = k;
                        break;
                    }
                }
            }
        }
        
        System.out.println(a + " " + b + " " + c);
        System.out.println(a * b * c);
        
    }
    
}
