/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programming_Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Master_Mind_Hints {

    public Master_Mind_Hints() throws IOException {
        Scanner lea = new Scanner();
        
        
        int t = 1;
        
        while(true){
            int n = lea.nextInt();
            
            if(n == 0) break;
        
            int secretCode[][] = new int[n][2];
            int guessCode[][] = new int[n][2];

            for (int i = 0; i < n; i++) {
                secretCode[i][0] = lea.nextInt();
                secretCode[i][1] = 0;
            }

            System.out.println("Game " + t + ":" );

            while(true){

                int zeros = 0;

                for (int i = 0; i < n; i++) {
                    guessCode[i][0] = lea.nextInt();
                    guessCode[i][1] = 0;

                    if(guessCode[i][0] == 0) zeros++;

                }

                if(zeros == n) break;

                int strong = 0;
                int weak = 0;

                for (int i = 0; i < n; i++) {
                    if(secretCode[i][0] == guessCode[i][0] && secretCode[i][1] == 0 && guessCode[i][1] == 0){
                        secretCode[i][1] = 1;
                        guessCode[i][1] = 1;
                        strong++;
                    }
                }

                for (int i = 0; i < n; i++) {
                    if(secretCode[i][1] == 1) continue;
                    for (int j = 0; j < n ; j++) {
                        if(secretCode[i][0] == guessCode[j][0] && secretCode[i][1] == 0 && guessCode[j][1] == 0){
                            secretCode[i][1] = 1;
                            guessCode[j][1] = 1;
                            weak++;
                        }
                    }
                }

                String aux = "(" + strong + "," + weak + ")";
                System.out.printf("    (%d,%d)\n",strong, weak);

                for (int i = 0; i < n; i++) {
                    secretCode[i][1] = 0;
                    guessCode[i][1] = 0;
                }
            }
            
            t++;
        }
        
        
        
        
    }
    
    class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer("");
        
        String next() throws IOException{
            while(!st.hasMoreTokens()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        
        int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
    }
    
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new Master_Mind_Hints();
    }
    
}
