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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 *
 * @author Hermanos-Jimenez
 */
public class Anagrams {
    
    ArrayList<Node> dictionary = new ArrayList<>();


    public Anagrams() throws IOException {
        Scanner lea = new Scanner();
        try(PrintWriter so = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))){
            String in = lea.next();
            dictionary.add(new Node(in, false));
            while(true){
                in = lea.next();

                if(in.equals("#")) break;

                if(!check(in.toLowerCase())){
                    dictionary.add(new Node(in, false));
                }
            }

            Collections.sort(dictionary);

            for (int i = 0; i < dictionary.size(); i++) {
                if(!dictionary.get(i).flag) so.println(dictionary.get(i).word);
            }
        }
        
        
        
    }
    
    
    boolean check(String in){
        
        for (int i = 0; i < dictionary.size(); i++) {
            if(dictionary.get(i).word.length() == in.length()){
                ArrayList<String> one = new ArrayList<>();
                ArrayList<String> two = new ArrayList<>();
                for (int j = 0; j < in.length(); j++) {
                    one.add(dictionary.get(i).word.toLowerCase().charAt(j) + "");
                    two.add(in.charAt(j) + "");
                }
                
                Collections.sort(one);
                Collections.sort(two);
                
                StringBuilder a = new StringBuilder();
                StringBuilder b = new StringBuilder();
                
                for (int j = 0; j < in.length(); j++) {
                    a.append(one.get(j));
                    b.append(two.get(j));
                }
                
                if(a.toString().equalsIgnoreCase(b.toString())){
                    dictionary.get(i).flag = true;
                    return true;
                }
            }
        }
        return false;
    }
    
    
    class Node implements Comparable<Node>{
        String word;
        boolean flag;

        public Node(String word, boolean flag) {
            this.word = word;
            this.flag = flag;
        }

        @Override
        public int compareTo(Node o) {
            return this.word.compareTo(o.word); 
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
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new Anagrams();
    }
    
}
