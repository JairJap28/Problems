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
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author Hermanos-Jimenez
 */
public class Expressions {
    
    String out[] = new String[5005];
    int level = 0;

    public Expressions() throws IOException {
        Scanner lea = new Scanner();
        
        for (int i = 0; i < 5005; i++) 
            out[i] = "";
        
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            int cases = lea.nextInt();
            for (int t = 0; t < cases; t++) {
                String in = lea.next();

                Stack<Node> data = new Stack<>();

                for (int i = 0; i < in.length(); i++) {

                    if(in.charAt(i) >= 'a'){
                        data.add(new Node(in.charAt(i)));
                    }
                    else{
                        data.add(new Node(data.pop(), data.pop(), in.charAt(i)));
                    }
                }

                Node a = data.pop();
                a.assingLevel(0);

                for (int i = level; i >= 0; i--) {
                    so.print(out[i]);
                    out[i] = "";
                }
                so.println();
            }
        }
    }
    
    
    class Node{
        Node right;
        Node left;
        char value;

        public Node(char val) {
            this.right = null;
            this.left = null;
            this.value = val;
        }
        
        public Node(Node right, Node left, char value) {
            this.right = right;
            this.left = left;
            this.value = value;
        }
        
        
        public void assingLevel(int start){
            out[start] += this.value;
            
            level = Math.max(level, start);
            
            if(this.right != null){
                this.right.assingLevel(start + 1);
            }
            if(this.left != null){
                this.left.assingLevel(start + 1);
            }  
        }
    }
    
    class Scanner{
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
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new Expressions();
    }
    
}
