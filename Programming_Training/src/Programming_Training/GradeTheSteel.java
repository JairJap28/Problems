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
public class GradeTheSteel {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            
            int casos = lea.nextInt();
            for(int i = 0; i < casos; i++){
                int hardness = lea.nextInt();
                double carbon = lea.nextDouble();
                int tensile = lea.nextInt();
                
                int facts[] = new int[3];
                facts[0] = (hardness > 50) ? 1 : 0;
                facts[1] = (carbon < 0.7) ? 1 : 0;
                facts[2] = (tensile > 5600) ? 1 : 0;
                
                boolean h = false, c = false, t = false;
                if(hardness > 50) h = true;
                if(carbon < 0.7) c = true;
                if(tensile > 5600) t = true;
                
                int grade;
                
                if(facts[0] == 1 && facts[1] == 1 && facts[2] == 1) grade = 10;
                else if(facts[0] == 1 && facts[1] == 1) grade = 9;
                else if(facts[1] == 1 && facts[2] == 1) grade = 8;
                else if(facts[0] == 1 && facts[2] == 1) grade = 7;
                else if(facts[0] == 1 || facts[1] == 1 || facts[2] == 1) grade = 6;
                else grade = 5;
                so.println(grade);
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
        
        public double nextDouble() throws IOException{
            return Double.parseDouble(next());
        }
    }
    
}
