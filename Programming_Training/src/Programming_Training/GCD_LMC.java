
package Programming_Training;

import java.math.BigInteger;
import java.util.Scanner;


public class GCD_LMC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        
        int cases = lea.nextInt();
        
        for(int i = 0; i < cases; i++){
            int a = lea.nextInt();
            int b = lea.nextInt();

            BigInteger aa = BigInteger.valueOf((long)a);
            BigInteger bb = BigInteger.valueOf((long) b);

            BigInteger gcd = aa.gcd(bb);

            BigInteger lcm = aa.multiply(bb);
            lcm = lcm.divide(gcd);

            System.out.println(gcd + " " + lcm);
        }
    }
    
}
