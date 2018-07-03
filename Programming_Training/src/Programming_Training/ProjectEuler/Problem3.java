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
public class Problem3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BigInteger num = new BigInteger("600851475143");
        BigInteger a = BigInteger.ONE;
        BigInteger b;
        BigInteger c = BigInteger.ONE;
        while(a.compareTo(num) == -1){
            a = a.nextProbablePrime();
            b = num.mod(a);
            if(b.equals(BigInteger.ZERO)){
                System.out.println(a.toString());
                c = c.max(a);
            }
        }
        
    }
    
}
