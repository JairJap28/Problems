/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class DevuAndGrapes {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */   
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        
        int cases = lea.nextInt();
        for (int t = 0; t < cases ;t++) {
            int n = lea.nextInt();
            int k = lea.nextInt();

            int bucket;
            long answer = 0;
            for (int i = 0; i < n; i++) {
                bucket = lea.nextInt();
                int mod = bucket % k;
                if(k > bucket) answer += k - bucket;
                else answer += Math.min(mod, k - mod);
            }

            System.out.println(answer);
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
