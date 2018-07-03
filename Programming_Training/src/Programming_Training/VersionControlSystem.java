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
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class VersionControlSystem {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lea = new Scanner();
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            
             int cases = lea.nextInt();
            for (int t = 0; t < cases; t++) {
                int n = lea.nextInt();
                int m = lea.nextInt();
                int k = lea.nextInt();
 
                HashMap<Integer, Node> check = new HashMap<>();
 
                for(int i = 0; i < m; i++){
                    int aux = lea.nextInt();
                    check.put(aux, new Node(true, false));
                }
 
                int value1 = 0;
 
                for(int i = 0; i < k; i++){
                    int aux = lea.nextInt();
                    if(check.containsKey(aux)){
                        check.put(aux, new Node(true, true));
                        value1++;
                    }
                    else check.put(aux, new Node(false, true));
                }
 
                int value2 = n - check.size();
 
                so.println(value1 + " " + value2);
            }
        }
    }
    
    static class Node{
        boolean tracked;
        boolean ignored;

        public Node(boolean tracked, boolean ignored) {
            this.tracked = tracked;
            this.ignored = ignored;
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
