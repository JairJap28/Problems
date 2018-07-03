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
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class CommandWar {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try (PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            int soldiers = lea.nextInt();
            facts save[] = new facts[soldiers];
            
            for (int i = 0; i < soldiers; i++) {
                save[i] = new facts(lea.nextInt(), lea.nextInt());
            }
            
            Arrays.sort(save);
            
            int s = 0;
            int ans = 0;
            
            for (int i = 0; i < soldiers; i++) {
                s += save[i].brief;
                ans = Math.max(ans, s + save[i].task);
            }
            
            so.println(ans);
        }
    }
    
    static class facts implements Comparable<facts>{
        int brief, task;

        public facts(int brief, int task) {
            this.brief = brief;
            this.task = task;
        }

        @Override
        public int compareTo(facts o) {
            return (this.task < o.task)? 1 : -1;
        }
    }
    
    static class Scanner{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new  BufferedReader(isr);
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
