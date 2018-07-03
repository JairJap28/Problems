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
public class Problem5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        boolean flag = false;
        int counter = 0;
        for (int i = 1; !flag; i++) {
            for (int j = 1; j <= 20; j++) {
                if(i % j == 0 && i % 2 == 0){
                    counter++;
                    continue;
                }
                counter = 0;
                break;
            }
            if(counter == 20){
                flag = true;
                counter = i;
            }
        }
        System.out.println(counter);
        
        
    }
    
}
