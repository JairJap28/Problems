/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class TanuAndHeadBob {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            
            int t = lea.nextInt();
            for(int j = 0; j < t; j++){
                int n = lea.nextInt();
                String gestures = lea.next();
                boolean yesNormal = false, noNormal = false, iIndian = false;
                for(int i = 0; i < gestures.length(); i++){
                    switch (gestures.charAt(i)) {
                        case 'Y':
                            so.println("NOT INDIAN");
                            yesNormal = true;
                            break;
                        case 'N':
                            noNormal = true;
                            break;
                        case 'I':
                            so.println("INDIAN");
                            iIndian = true;
                            break;
                    }
                }   
                if(noNormal && !iIndian && !yesNormal) so.println("NOT SURE");
                else if(noNormal && iIndian && yesNormal) so.println("NOT SURE");
                else if(yesNormal && !noNormal && !iIndian) so.println("NOT INDIAN");
                else if(yesNormal && noNormal && !iIndian) so.println("NOT INDIAN");
                else if(iIndian && !noNormal && !yesNormal) so.println("INDIAN");
                else if(iIndian && noNormal && !yesNormal) so.println("INDIAN");                                                        
            }
        }
    }
    
    static class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        
        public String next() throws IOException{
            while(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        public int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
    }
    
}
