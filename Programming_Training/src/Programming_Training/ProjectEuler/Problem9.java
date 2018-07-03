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
public class Problem9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int a,b,c;
         
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                for (int k = 0; ; k++) {
                    if(Math.sqrt(((i * i) + (j * j) + (k * k))) == 1000){
                        a = i;
                        b = j;
                        c = k;
                        break;
                    }
                }
            }
        }
        
    }
    
}
