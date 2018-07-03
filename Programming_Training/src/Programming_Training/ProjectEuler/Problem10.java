    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training.ProjectEuler;

import java.math.BigInteger;

/**
 *
 * @author Hermanos-Jimenez
 */
public class Problem10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BigInteger a = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;
        int limit = 0;
        
        
        while(true){
            int res = a.nextProbablePrime().compareTo(BigInteger.valueOf((2000000)));
            if(res == 1) break;
            
            a = a.nextProbablePrime();
            sum = sum.add(a);
            
            limit++;
        }
        
        System.out.println(sum.toString());
        
    }
    
}
